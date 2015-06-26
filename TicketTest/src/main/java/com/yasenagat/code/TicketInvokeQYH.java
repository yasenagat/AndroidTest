package com.yasenagat.code;

/**
 * Created by zf on 2015/6/11.
 */
public class TicketInvokeQYH extends AbstractTickerInvoke {

    @Override
    public ITicketCreater getITicketCreater() {
        return new DefaultITicketCreater();
    }

    @Override
    public IBatch getIBatch() {
        return new BatchQYH();
    }

    @Override
    public IParse getIParse() {
        return new QYHParse();
    }

}
