package com.kingschan.fastquery.sql.query.pagination;

import com.kingschan.fastquery.sql.dto.DataTransfer;



/**
 * <pre>
 * @author kingschan
 * date:2012-11-27
 * description:
 * </pre>
 */
public interface Query {
	/**
	 * 分页查询
	 * @param dt
	 * @return
	 * @throws Exception
     */
	DataTransfer paginationQuery(DataTransfer dt)throws Exception;

}
