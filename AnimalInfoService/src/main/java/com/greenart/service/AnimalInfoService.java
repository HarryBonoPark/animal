package com.greenart.service;

import java.text.DecimalFormat;
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

    public AnimalInfoVO selectAnimalTodayStatusByDate(){
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

        return mapper.selectAnimalStatusByDate();
    }
    public AnimalInfoVO selectAnimalStatusInfo(){
        return mapper.selectAnimalStatusByDate();
    }

    // public AnimalInfoVO selectAnimalTodayStatusByDate(){
    //     Calendar now = Calendar.getInstance();
    //     Calendar standard = Calendar.getInstance();
    //     standard.set(Calendar.HOUR_OF_DAY, 10);
    //     standard.set(Calendar.MINUTE, 30);
    //     standard.set(Calendar.SECOND, 00);

    //     if(now.getTimeInMillis() < standard.getTimeInMillis()){
    //         // 현재 접속시간이 기준시간 (10시 30분) 보다 이전일 때
    //         // 하루 이전 날짜로 변경
    //         now.add(Calendar.DATE, -1);
            
    //     }
    //     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    //     String dt = formatter.format(now.getTime());

    //     return mapper.selectAnimalStatusByDate(dt);
    // }
    // public AnimalInfoVO selectAnimalStatusInfo(String date){
    //     return mapper.selectAnimalStatusByDate(date);
    // }

    public AnimalInfoVO selectTodayCntStatusByDate(){    
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 10);
        standard.set(Calendar.MINUTE, 30);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            // 현재 접속시간이 기준시간 (10시 30분 10초) 보다 이전일 때
            // 하루 이전 날짜로 변경
            now.add(Calendar.DATE, -1);
            
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());

        AnimalInfoVO data = mapper.selectCntStatusByDate(dt);

        Integer cnt = data.getCnt();

        DecimalFormat dFormatter = new DecimalFormat("###,###");
        String strCnt = dFormatter.format(cnt);

        data.setStrCnt(strCnt);

        return data;

        // return mapper.selectCntStatusByDate(dt);
    }
    public AnimalInfoVO selectCntStatusByDate(String date){    
        return mapper.selectCntStatusByDate(date);
    }
    public AnimalInfoVO selectTodayAllCntByDate(){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 10);
        standard.set(Calendar.MINUTE, 30);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            // 현재 접속시간이 기준시간 (10시 30분 10초) 보다 이전일 때
            // 하루 이전 날짜로 변경
            now.add(Calendar.DATE, -1);
            
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());

        AnimalInfoVO data = mapper.selectAllCntByDate(dt);
        Integer noCnt = data.getNoCnt();

        DecimalFormat dFormatter = new DecimalFormat("###,###");
        String strAllCnt = dFormatter.format(noCnt);

        data.setStrAllCnt(strAllCnt);

        return data;

        // return mapper.selectAllCntByDate(dt);
    }
    public AnimalInfoVO selectAllCntByDate(String date){
        return mapper.selectAllCntByDate(date);
    }

    public List<AnimalInfoVO> selectRegionInfoByDate(){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 10);
        standard.set(Calendar.MINUTE, 30);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            // 현재 접속시간이 기준시간 (10시 30분 10초) 보다 이전일 때
            // 하루 이전 날짜로 변경
            now.add(Calendar.DATE, -1);
            
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());

        return mapper.selectRegionInfoByDate(dt);
    }
    public List<AnimalInfoVO> selectRegionInfo(String date){
        return mapper.selectRegionInfoByDate(date);
    }

    public List<AnimalInfoVO> selectanimalSex(){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 10);
        standard.set(Calendar.MINUTE, 00);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            now.add(Calendar.DATE, -1);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());


        return mapper.selectanimalSex(dt);
    }
    public List<AnimalInfoVO> selectanimalSex(String date){
        return mapper.selectanimalSex(date);
    }

    public List<AnimalInfoVO> selectTodaySexAnimalCnt(){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 10);
        standard.set(Calendar.MINUTE, 00);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            now.add(Calendar.DATE, -1);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());


        return mapper.selectSexAnimalCnt(dt);
    }
    public List<AnimalInfoVO> selectSexAnimalInfo(String date){
        return mapper.selectSexAnimalCnt(date);
    }

    public List<AnimalInfoVO> selectTodayCntRegion(){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 10);
        standard.set(Calendar.MINUTE, 00);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            now.add(Calendar.DATE, -1);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());

        return mapper.selectCntRegion(dt);
    }
    public List<AnimalInfoVO> selectCntRegion(String date){
        return mapper.selectCntRegion(date);
    }

    public List<AnimalInfoVO> selectTodayNeuterCnt(){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 10);
        standard.set(Calendar.MINUTE, 00);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            now.add(Calendar.DATE, -1);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());

        return mapper.selectNeuterCnt(dt);
    }
    public List<AnimalInfoVO> selectNeuterCnt(String date){
        return mapper.selectNeuterCnt(date);
    }
}
