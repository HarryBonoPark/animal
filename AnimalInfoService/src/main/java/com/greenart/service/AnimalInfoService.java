package com.greenart.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.greenart.mapper.AnimalInfoMapper;
import com.greenart.vo.AnimalInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalInfoService {
    @Autowired AnimalInfoMapper mapper;

    public void insertAnimalInfo(AnimalInfoVO vo) {
        mapper.insertAnimalInfo(vo);
    }
    // Today
    public AnimalInfoVO selectTodayAnimalInfo(){
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // String date = formatter.format(now);
        String date = formatter.format(now);

        return mapper.selectAnimalInfoByDate(date);
    }

    public AnimalInfoVO selectAnimalInfoByDate(String date){
        return mapper.selectAnimalInfoByDate(date);
    }

    // 누적
    public AnimalInfoVO selectTodayAccAnimalInfo(){
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat();
        String date = formatter.format(now);

        return mapper.selectAnimalInfoByDate(date);
    }

    public AnimalInfoVO selectAccAnimalCnt(String date){
        return mapper.selectAccAnimalCnt(date);
    }

    public List<AnimalInfoVO> selectAnimalTodayStatusByDate(String date){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 10);
        standard.set(Calendar.MINUTE, 30);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            // 현재 접속시간이 기준시간 (10시 30분) 보다 이전일 때
            // 하루 이전 날짜로 변경
            now.add(Calendar.DATE, -1);
            
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());

        return mapper.selectAnimalStatusByDate(dt);
    }
    public List<AnimalInfoVO> selectAnimalStatusInfo(String date){
        return mapper.selectAnimalStatusByDate(date);
    }
}
