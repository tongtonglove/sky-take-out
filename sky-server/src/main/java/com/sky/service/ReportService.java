package com.sky.service;

import com.sky.vo.TurnoverReportVO;
import com.sky.vo.UserReportVO;

import java.time.LocalDate;

public interface ReportService {

    /**
     * 统计指定时间区间内营业额的数据
     * @param begin
     * @param end
     * @return
     */
    TurnoverReportVO getTurnover(LocalDate begin,LocalDate end);

    /**
     * 统计指定时间区内的用户数量
     * @param begin
     * @param end
     * @return
     */
    UserReportVO getUserStatistics(LocalDate begin,LocalDate end);
}
