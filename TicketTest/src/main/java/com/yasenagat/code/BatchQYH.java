package com.yasenagat.code;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zf on 2015/6/11.
 */
public class BatchQYH implements IBatch {

    /**
     * @param codeList 0=单式，1=复式，2胆拖
     * @return
     */
    @Override
    public List<TicketInfo> batch(List<List<CodeInfo>> codeList, String times) {

        List<TicketInfo> lTicketInfos = new ArrayList<TicketInfo>();

        try {
            if (null != codeList && codeList.size() >= 3) {

                List<CodeInfo> list = codeList.get(0);
                List<CodeInfo> danshi_list = new ArrayList<CodeInfo>(), fushi_list = codeList.get(1), dantuo_list = codeList.get(2), other_list = new ArrayList<CodeInfo>();

                //任7以上
                for (CodeInfo lCodeInfo : list) {
                    if ("38".equals(lCodeInfo.getSaleId())
                            || "41".equals(lCodeInfo.getSaleId())
                            || "44".equals(lCodeInfo.getSaleId())
                            || "47".equals(lCodeInfo.getSaleId())) {
                        other_list.add(lCodeInfo);
                    }else {
                        danshi_list.add(lCodeInfo);
                    }
                }

                int total = danshi_list.size();
                int item = 5;
                int left = total % item;
                int items = (total - left) / item;

                TicketInfo lTicketInfo;
                StringBuffer code;
                BigDecimal money;

                for (int i = 0; i < items; i++) {
                    lTicketInfo = new TicketInfo();
                    code = new StringBuffer();
                    money = new BigDecimal(0);

                    for (int j = 0; j < item; j++) {

                        int index = i * item + j;

                        code.append(danshi_list.get(index).getCode());

                        money = money.add(new BigDecimal(danshi_list.get(index).getNote()).multiply(ITicketCreater.EACH_NOTE).multiply(new BigDecimal(times)));
                    }

                    lTicketInfo.setCode(code.toString());
                    lTicketInfo.setMoney(money.toString());
                    lTicketInfo.setRunCode(createRunCode());

                    lTicketInfos.add(lTicketInfo);
                }


                if (left > 0) {
                    lTicketInfo = new TicketInfo();
                    code = new StringBuffer();
                    money = new BigDecimal(0);

                    for (int i = 0; i < left; i++) {
                        int index = items * item + i;
                        code.append(danshi_list.get(index).getCode());
                        money = money.add(new BigDecimal(danshi_list.get(index).getNote()).multiply(ITicketCreater.EACH_NOTE).multiply(new BigDecimal(times)));
                    }

                    lTicketInfo.setCode(code.toString());
                    lTicketInfo.setMoney(money.toString());
                    lTicketInfo.setRunCode(createRunCode());
                    lTicketInfos.add(lTicketInfo);
                }

                for (CodeInfo lCodeInfo : fushi_list) {

                    lTicketInfo = new TicketInfo();

                    lTicketInfo.setCode(lCodeInfo.getCode());
                    lTicketInfo.setMoney(new BigDecimal(lCodeInfo.getNote()).multiply(ITicketCreater.EACH_NOTE).multiply(new BigDecimal(times)).toString());
                    lTicketInfo.setRunCode(createRunCode());
                    lTicketInfos.add(lTicketInfo);
                }

                for (CodeInfo lCodeInfo : dantuo_list) {

                    lTicketInfo = new TicketInfo();

                    lTicketInfo.setCode(lCodeInfo.getCode());
                    lTicketInfo.setMoney(new BigDecimal(lCodeInfo.getNote()).multiply(ITicketCreater.EACH_NOTE).multiply(new BigDecimal(times)).toString());
                    lTicketInfo.setRunCode(createRunCode());
                    lTicketInfos.add(lTicketInfo);
                }
                for (CodeInfo lCodeInfo : other_list) {

                    lTicketInfo = new TicketInfo();

                    lTicketInfo.setCode(lCodeInfo.getCode());
                    lTicketInfo.setMoney(new BigDecimal(lCodeInfo.getNote()).multiply(ITicketCreater.EACH_NOTE).multiply(new BigDecimal(times)).toString());
                    lTicketInfo.setRunCode(createRunCode());
                    lTicketInfos.add(lTicketInfo);
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lTicketInfos;
    }

    public String createRunCode() {
        return PrimaryGenerater.getID();
    }
}
