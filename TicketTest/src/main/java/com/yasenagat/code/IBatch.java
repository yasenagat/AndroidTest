package com.yasenagat.code;

import java.util.List;

/**
 * Created by zf on 2015/6/11.
 */
public interface IBatch {

    public List<TicketInfo> batch(List<List<CodeInfo>> codeList, String times);
}
