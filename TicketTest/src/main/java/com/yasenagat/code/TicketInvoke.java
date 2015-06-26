package com.yasenagat.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zf on 2015/6/11.
 */
public class TicketInvoke {

    public static final Map<String, AbstractTickerInvoke> invokeMap = new HashMap<String, AbstractTickerInvoke>();

    static {

        invokeMap.put("SSQ", new TicketInvokeSSQ());
        invokeMap.put("QLC", new TicketInvokeQLC());
        invokeMap.put("QYH", new TicketInvokeQYH());
        invokeMap.put("FC3D", new TicketInvokeFC3D());
    }

    public static String execute(String lotteryId, List<CodeInfo> codeInfos, String times) {

        AbstractTickerInvoke lAbstractTickerInvoke = invokeMap.get(lotteryId);

        if (null == lAbstractTickerInvoke) {
            return null;
        }
        return lAbstractTickerInvoke.getTickets(codeInfos, times);
    }
}
