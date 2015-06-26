package com.yasenagat.code;

import com.dgcy.mymodule.app2.StringUtil;

import java.util.List;

/**
 * Created by zf on 2015/6/11.
 */
public class CodeUtil {

    public static void parseCode(String code, List<String> _tuo_red, List<String> _dan_red, List<String> _tuo_blue, List<String> _dan_blue) {

        try {

            if (!StringUtil.isEmpty(code)) {

                String[] _f = code.split("\\|");

                if (_f != null && _f.length > 0) {

                    String[] _t = null;

                    //红球篮球
                    for (int i = 0; i < _f.length; i++) {

//                        GlobalLog.d(TAG, "_f[i] : " + _f[i]);

                        //没有胆
                        if (_f[i] != null && _f[i].indexOf("*") == -1) {

                            _t = _f[i].split(",");

                            if (_t != null & _t.length > 0) {

                                for (int j = 0; j < _t.length; j++) {

                                    if (i == 0) {
                                        _tuo_red.add(_t[j]);
                                    } else if (i == 1) {
                                        _tuo_blue.add(_t[j]);
                                    }

                                }
                            }

                        } else {

                            String[] _s = null;

                            _s = _f[i].split("\\*");

                            if (_s != null /*&& _s.length == 2*/) {
                                //有胆

                                _t = _s[0].split(",");

                                //胆

                                if (_t != null & _t.length > 0) {

                                    for (int j = 0; j < _t.length; j++) {

                                        if (i == 0) {
                                            _dan_red.add(_t[j]);
                                        } else if (i == 1) {
                                            _dan_blue.add(_t[j]);
                                        }

                                    }
                                }

                                if (_s.length == 2) {
                                    _t = _s[1].split(",");

                                    if (_t != null & _t.length > 0) {
                                        for (int j = 0; j < _t.length; j++) {

                                            if (i == 0) {
                                                _tuo_red.add(_t[j]);
                                            } else if (i == 1) {
                                                _tuo_blue.add(_t[j]);
                                            }
                                        }
                                    }
                                }

                            } else {

                            }
                        }


                        //noly apply 2
                        if (i == 1) {
                            break;
                        }
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseCode(String code, List<String> _tuo_red, List<String> _dan_red) {

        try {

            if (!StringUtil.isEmpty(code)) {

                String[] _t = null;

                //没有胆
                if (code != null && code.indexOf("*") == -1) {

                    _t = code.split(",");

                    if (_t != null & _t.length > 0) {

                        for (int j = 0; j < _t.length; j++) {
                            _tuo_red.add(_t[j]);
                        }
                    }

                } else {

                    String[] _s = null;

                    _s = code.split("\\*");

                    if (_s != null /*&& _s.length == 2*/) {
                        //有胆

                        _t = _s[0].split(",");

                        //胆
                        if (_t != null & _t.length > 0) {

                            for (int j = 0; j < _t.length; j++) {
                                _dan_red.add(_t[j]);
                            }
                        }
                        //拖
                        if (_s.length == 2) {
                            _t = _s[1].split(",");

                            if (_t != null & _t.length > 0) {
                                for (int j = 0; j < _t.length; j++) {
                                    _tuo_red.add(_t[j]);
                                }
                            }
                        }

                    } else {

                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getCode(List<String> codes) {

        StringBuffer ret = new StringBuffer("");

        for (String code : codes) {
            ret.append(code);
        }

        return ret.toString();
    }

    public static String getCode_append0(List<String> codes) {

        StringBuffer ret = new StringBuffer("");

        for (String code : codes) {
            if (code.length() == 1) {
                ret.append("0");
            }
            ret.append(code);
        }

        return ret.toString();
    }

    public static String[] getCode_append0(String codes) {

        String[] ret = new String[2];
        StringBuffer sb = new StringBuffer("");
        String c[] = codes.split(",");
        for (String code : c) {
            if (code.length() == 1) {
                sb.append("0");
            }
            sb.append(code);
        }

        ret[0] = c.length < 10 ? "0" + c.length : c.length + "";
        ret[1] = sb.toString();
        return ret;
    }

}
