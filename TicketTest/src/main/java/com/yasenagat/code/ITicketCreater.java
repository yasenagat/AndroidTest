package com.yasenagat.code;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zf on 2015/6/11.
 */
public interface ITicketCreater {

    public static final String TAB = "\t";
    public static final String AT = "@";
    public static final String TICK = "^";
    public static final String TILDE = "~";
    public static final String STAR = "*";
    public static final BigDecimal EACH_NOTE = new BigDecimal(2);


    public String getTickets(List<TicketInfo> ticketInfos);

}
