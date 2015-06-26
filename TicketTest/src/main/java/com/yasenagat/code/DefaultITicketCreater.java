package com.yasenagat.code;

import java.util.List;

/**
 * Created by zf on 2015/6/11.
 */
public class DefaultITicketCreater implements ITicketCreater {

    @Override
    public String getTickets(List<TicketInfo> ticketInfos) {
        StringBuffer ret = new StringBuffer("");

        try {
            if (null != ticketInfos && ticketInfos.size() > 0) {

                TicketInfo lTicketInfo;
                for (int i = 0; i < ticketInfos.size(); i++) {
                    lTicketInfo = ticketInfos.get(i);
                    ret.append(lTicketInfo.getRunCode());
                    ret.append(ITicketCreater.TAB);
                    ret.append(lTicketInfo.getMoney());
                    ret.append(ITicketCreater.TAB);
                    ret.append(lTicketInfo.getCode());

                    if (i != ticketInfos.size() - 1) {
                        ret.append(ITicketCreater.AT);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return ret.toString();
    }
}
