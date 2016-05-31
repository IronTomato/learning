package com.sls.sample.common;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;
/**
 * 由于Strust默认没有BigDecimal的转换器，自定义BigDecimal转换器用于BigDecimal和String的互转
 * @author wnb
 *
 */
public class StrutsBigDecimalConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if (values == null || StringUtils.isBlank(values[0])) {
			return null;
		} else {
			return new BigDecimal(values[0]);
		}
	}

	@Override
	public String convertToString(Map context, Object o) {
		return o.toString();
	}

}
