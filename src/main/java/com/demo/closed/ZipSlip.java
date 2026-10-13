package com.demo.closed;
import java.io.*;
import java.util.zip.*;
// cognium-dev#620 — ZipEntry.getName() into a file path
public class ZipSlip {
  public void unjar(ZipInputStream zis, File dir) throws Exception {
    ZipEntry e;
    while ((e = zis.getNextEntry()) != null) {
      File out = new File(dir, e.getName()); // SINK CWE-22
      out.getParentFile().mkdirs();
      try (OutputStream os = new FileOutputStream(out)) {
        zis.transferTo(os);
      }
    }
  }
}
