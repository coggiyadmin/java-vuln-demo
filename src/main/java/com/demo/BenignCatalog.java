package com.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * BENIGN-BASELINE TRUE-NEGATIVE FIXTURE.
 *
 * Ordinary business logic with NO security surface: no HTTP, no DB, no file
 * I/O, no exec, no crypto, no secrets. The scanner MUST produce ZERO security
 * findings here. This measures specificity / the "noise floor" — spurious
 * security findings on innocuous code are a defect.
 */
public final class BenignCatalog {

    /** A product line item with a unit price and quantity. */
    public record LineItem(String sku, BigDecimal unitPrice, int quantity) {
        /** Extended price for this line (unitPrice × quantity). */
        public BigDecimal extended() {
            return unitPrice.multiply(BigDecimal.valueOf(quantity));
        }
    }

    /** Discount tiers applied by subtotal threshold. */
    public enum Tier {
        STANDARD(BigDecimal.ZERO),
        SILVER(new BigDecimal("0.05")),
        GOLD(new BigDecimal("0.10"));

        private final BigDecimal rate;
        Tier(BigDecimal rate) { this.rate = rate; }
        /** Fractional discount rate for this tier. */
        public BigDecimal rate() { return rate; }
    }

    /** Sum of all line extended prices, rounded to cents. */
    public BigDecimal subtotal(List<LineItem> items) {
        return items.stream()
            .map(LineItem::extended)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .setScale(2, RoundingMode.HALF_UP);
    }

    /** Choose a discount tier from the subtotal. */
    public Tier tierFor(BigDecimal subtotal) {
        if (subtotal.compareTo(new BigDecimal("1000")) >= 0) return Tier.GOLD;
        if (subtotal.compareTo(new BigDecimal("250")) >= 0) return Tier.SILVER;
        return Tier.STANDARD;
    }

    /** Final total after applying the tier discount. */
    public BigDecimal total(List<LineItem> items) {
        BigDecimal sub = subtotal(items);
        BigDecimal discount = sub.multiply(tierFor(sub).rate());
        return sub.subtract(discount).setScale(2, RoundingMode.HALF_UP);
    }

    /** Group line items by SKU prefix (category code before the dash). */
    public Map<String, List<LineItem>> byCategory(List<LineItem> items) {
        return items.stream().collect(Collectors.groupingBy(li -> {
            int dash = li.sku().indexOf('-');
            return dash > 0 ? li.sku().substring(0, dash) : "misc";
        }));
    }

    /** SKUs sorted by descending extended price. */
    public List<String> topSkus(List<LineItem> items, int limit) {
        return items.stream()
            .sorted(Comparator.comparing(LineItem::extended).reversed())
            .limit(limit)
            .map(LineItem::sku)
            .collect(Collectors.toList());
    }
}
