package com.yasenagat.code;

import java.util.List;

/**
 * Created by zf on 2015/6/11.
 */
public abstract class AbstractTickerInvoke {

    public String getTickets(List<CodeInfo> codeInfos, String times) {
        try {
            return getITicketCreater().getTickets(getIBatch().batch(getIParse().parse(codeInfos, times), times));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public abstract ITicketCreater getITicketCreater();

    public abstract IBatch getIBatch();

    public abstract IParse getIParse();
}
