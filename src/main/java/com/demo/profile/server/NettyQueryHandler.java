// TP (elarasu cognium-dev#154) — SERVER profile. A Netty ChannelInboundHandler IS a real
// request entry point; data read off the channel is attacker-controlled. sql_injection here
// SHOULD fire — tests non-Servlet entry-point recognition.
package com.demo.profile.server;

import java.sql.Connection;
import java.sql.Statement;

public class NettyQueryHandler {
    private Connection conn;
    // channelRead0(ctx, msg) — msg is the decoded request (attacker-controlled entry point)
    protected void channelRead0(Object ctx, String msg) throws Exception {
        Statement st = conn.createStatement();
        st.executeQuery("SELECT * FROM items WHERE name = '" + msg + "'"); // SINK (entry-point reachable)
    }
}
