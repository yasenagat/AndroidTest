package com.yasenagat.code;

import java.util.List;

/**
 * Created by zf on 2015/6/11.
 */
public interface IParse {

    public List<List<CodeInfo>> parse(List<CodeInfo> codeInfos, String times);

    public String parse(CodeInfo codeInfo, String times);
}
