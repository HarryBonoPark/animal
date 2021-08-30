package com.greenart.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.greenart.mapper.AnimalInfoMapper;
import com.greenart.vo.AnimalInfoVO;
import com.greenart.vo.CatInfoVO;
import com.greenart.vo.OtherInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalInfoService {
    @Autowired AnimalInfoMapper mapper;
// DOG
    public void insertAnimalInfo(AnimalInfoVO vo) {
        mapper.insertAnimalInfo(vo);
    }
    // Today
    // public AnimalInfoVO selectTodayAnimalInfo(){
    //     Date now = new Date();
    //     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    //     // String date = formatter.format(now);
    //     String date = formatter.format(now);

    //     return mapper.selectAnimalInfoByDate(date);
    // }

    // public AnimalInfoVO selectAnimalInfoByDate(String date){
    //     return mapper.selectAnimalInfoByDate(date);
    // }

    // // 누적
    // public AnimalInfoVO selectTodayAccAnimalInfo(){
    //     Date now = new Date();
    //     SimpleDateFormat formatter = new SimpleDateFormat();
    //     String date = formatter.format(now);

    //     return mapper.selectAnimalInfoByDate(date);
    // }

    // public AnimalInfoVO selectAccAnimalCnt(String date){
    //     return mapper.selectAccAnimalCnt(date);
    // }

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
    // public AnimalInfoVO selectAnimalStatusInfo(){
    //     return mapper.selectAnimalStatusByDate();
    // }

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
        standard.set(Calendar.HOUR_OF_DAY, 23);
        standard.set(Calendar.MINUTE, 59);
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
        standard.set(Calendar.HOUR_OF_DAY, 23);
        standard.set(Calendar.MINUTE, 59);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            // 현재 접속시간이 기준시간 (10시 30분 10초) 보다 이전일 때
            // 하루 이전 날짜로 변경
            now.add(Calendar.DATE, -1);
            
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());

        AnimalInfoVO data = mapper.selectAllCntByDate();
        Integer noCnt = data.getNoCnt();

        DecimalFormat dFormatter = new DecimalFormat("###,###");
        String strAllCnt = dFormatter.format(noCnt);

        data.setStrAllCnt(strAllCnt);

        return data;

        // return mapper.selectAllCntByDate(dt);
    }
    public AnimalInfoVO selectAllCntByDate(){
        return mapper.selectAllCntByDate();
    }

    // public List<AnimalInfoVO> selectRegionInfoByDate(){
    //     Calendar now = Calendar.getInstance();
    //     Calendar standard = Calendar.getInstance();
    //     standard.set(Calendar.HOUR_OF_DAY, 23);
    //     standard.set(Calendar.MINUTE, 59);
    //     standard.set(Calendar.SECOND, 00);

    //     if(now.getTimeInMillis() < standard.getTimeInMillis()){
    //         // 현재 접속시간이 기준시간 (10시 30분 10초) 보다 이전일 때
    //         // 하루 이전 날짜로 변경
    //         now.add(Calendar.DATE, -1);
            
    //     }
    //     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    //     String dt = formatter.format(now.getTime());

    //     return mapper.selectRegionInfoByDate(dt);
    // }
    // public List<AnimalInfoVO> selectRegionInfo(String date){
    //     return mapper.selectRegionInfoByDate(date);
    // }

    // public List<AnimalInfoVO> selectanimalSex(){
    //     Calendar now = Calendar.getInstance();
    //     Calendar standard = Calendar.getInstance();
    //     standard.set(Calendar.HOUR_OF_DAY, 23);
    //     standard.set(Calendar.MINUTE, 59);
    //     standard.set(Calendar.SECOND, 00);

    //     if(now.getTimeInMillis() < standard.getTimeInMillis()){
    //         now.add(Calendar.DATE, -1);
    //     }
    //     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    //     String dt = formatter.format(now.getTime());


    //     return mapper.selectanimalSex(dt);
    // }
    // public List<AnimalInfoVO> selectanimalSex(String date){
    //     return mapper.selectanimalSex(date);
    // }

    public List<AnimalInfoVO> selectTodaySexAnimalCnt(){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 23);
        standard.set(Calendar.MINUTE, 59);
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
        standard.set(Calendar.HOUR_OF_DAY, 23);
        standard.set(Calendar.MINUTE, 59);
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
        standard.set(Calendar.HOUR_OF_DAY, 23);
        standard.set(Calendar.MINUTE, 59);
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
    public List<AnimalInfoVO> selectTodayMonthDogCnt(){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 23);
        standard.set(Calendar.MINUTE, 59);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            now.add(Calendar.DATE, -1);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());

        return mapper.selectMonthDogCnt(dt);
    }
    public List<AnimalInfoVO> selectMonthDogCnt(String date){
    return mapper.selectMonthDogCnt(date);
    }

    public List<AnimalInfoVO> selectTodayDogProcessState(){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 23);
        standard.set(Calendar.MINUTE, 59);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            now.add(Calendar.DATE, -1);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());

        return mapper.selectDogProcessState(dt);

        // AnimalInfoVO data = mapper.selectDogProcessState(dt);

        // Integer dogState = data.getDogState();

        // DecimalFormat dFormatter = new DecimalFormat("###,###");
        // String strDogState = dFormatter.format(dogState);

        // data.setStrDogState(strDogState);

        // return data;
    }

    public List<AnimalInfoVO> selectDogProcessState(String date){
        return mapper.selectDogProcessState(date);
}




// CAT
    // public void insertCatInfo(CatInfoVO vo){
    //     mapper.insertCatInfo(vo);
    // }

    public CatInfoVO selectTodayCatCntStatusByDate(){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 23);
        standard.set(Calendar.MINUTE, 59);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            // 현재 접속시간이 기준시간 (10시 30분 10초) 보다 이전일 때
            // 하루 이전 날짜로 변경
            now.add(Calendar.DATE, -1);
            
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());

        CatInfoVO data = mapper.selectCatCntStatusByDate(dt);

        Integer cnt = data.getC_cnt();

        DecimalFormat dFormatter = new DecimalFormat("###,###");
        String strCnt = dFormatter.format(cnt);

        data.setC_strCnt(strCnt);

        return data;
    }
    public CatInfoVO selectCatCntStatusByDate(String date){
        return mapper.selectCatCntStatusByDate(date);
    }
    public CatInfoVO selectTodayAllCatCntByDate(){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 23);
        standard.set(Calendar.MINUTE, 59);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            // 현재 접속시간이 기준시간 (10시 30분 10초) 보다 이전일 때
            // 하루 이전 날짜로 변경
            now.add(Calendar.DATE, -1);
            
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());

        CatInfoVO data = mapper.selectAllCatCntByDate(dt);
        Integer noCnt = data.getC_noCnt();

        DecimalFormat dFormatter = new DecimalFormat("###,###");
        String strAllCnt = dFormatter.format(noCnt);

        data.setC_strAllCnt(strAllCnt);

        return data;
    }
    public CatInfoVO selectAllCatCntByDate(String date){
        return mapper.selectAllCatCntByDate(date);
    }

    public List<CatInfoVO> selectTodayCatSexAnimalCnt(){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 23);
        standard.set(Calendar.MINUTE, 59);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            now.add(Calendar.DATE, -1);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());


        return mapper.selectCatSexAnimalCnt(dt);
    }
    public List<CatInfoVO> selectCatSexAnimalCnt(String date){
        return mapper.selectCatSexAnimalCnt(date);
    }
    public List<CatInfoVO> selectTodayCatCntRegion(){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 23);
        standard.set(Calendar.MINUTE, 59);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            now.add(Calendar.DATE, -1);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());

        return mapper.selectCatCntRegion(dt);
    }
    public List<CatInfoVO> selectCatCntRegion(String date){
        return mapper.selectCatCntRegion(date);
    }
    public List<CatInfoVO> selectTodayCatNeuterCnt(){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 23);
        standard.set(Calendar.MINUTE, 59);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            now.add(Calendar.DATE, -1);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());

        return mapper.selectCatNeuterCnt(dt);
    }
    public List<CatInfoVO> selectCatNeuterCnt(String date){
        return mapper.selectCatNeuterCnt(date);
    }
    public List<CatInfoVO> selectTodayMonthCatCnt(){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 23);
        standard.set(Calendar.MINUTE, 59);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            now.add(Calendar.DATE, -1);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());

        return mapper.selectMonthCatCnt(dt);
    }
    public List<CatInfoVO> selectMonthCatCnt(String date)   {
        return mapper.selectMonthCatCnt(date);
    }

    public List<CatInfoVO> selectTodayCatProcessState(){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 23);
        standard.set(Calendar.MINUTE, 59);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            now.add(Calendar.DATE, -1);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());

        return mapper.selectCatProcessState(dt);

        // CatInfoVO data = mapper.selectCatProcessState(dt);

        // Integer catState = data.getCatState();

        // DecimalFormat dFormatter = new DecimalFormat("###,###");
        // String strCatState = dFormatter.format(catState);

        // data.setStrCatState(strCatState);

        // return data;
    }
    public List<CatInfoVO> selectCatProcessState(String date){
        return mapper.selectCatProcessState(date);
    }





    // OTHER
    public OtherInfoVO selectTodayOtherCntStatusByDate(){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 23);
        standard.set(Calendar.MINUTE, 59);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            // 현재 접속시간이 기준시간 (10시 30분 10초) 보다 이전일 때
            // 하루 이전 날짜로 변경
            now.add(Calendar.DATE, -1);
            
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());

        OtherInfoVO data = mapper.selectOtherCntStatusByDate(dt);

        Integer cnt = data.getO_cnt();

        DecimalFormat dFormatter = new DecimalFormat("###,###");
        String strCnt = dFormatter.format(cnt);

        data.setO_strCnt(strCnt);

        return data;
    }
    public OtherInfoVO selectOtherCntStatusByDate(String date){
        return mapper.selectOtherCntStatusByDate(date);
    }
    public OtherInfoVO selectTodayAllOtherCntByDate(){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 23);
        standard.set(Calendar.MINUTE, 59);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            // 현재 접속시간이 기준시간 (10시 30분 10초) 보다 이전일 때
            // 하루 이전 날짜로 변경
            now.add(Calendar.DATE, -1);
            
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());

        OtherInfoVO data = mapper.selectAllOtherCntByDate(dt);
        Integer noCnt = data.getO_noCnt();

        DecimalFormat dFormatter = new DecimalFormat("###,###");
        String strAllCnt = dFormatter.format(noCnt);

        data.setO_strAllCnt(strAllCnt);

        return data;
    }
    public OtherInfoVO selectAllOtherCntByDate(String date){
        return mapper.selectAllOtherCntByDate(date);
    }

    public List<OtherInfoVO> selectTodayOtherSexAnimalCnt(){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 23);
        standard.set(Calendar.MINUTE, 59);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            now.add(Calendar.DATE, -1);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());


        return mapper.selectOtherSexAnimalCnt(dt);
    }
    public List<OtherInfoVO> selectOtherSexAnimalCnt(String date){
        return mapper.selectOtherSexAnimalCnt(date);
    }
    public List<OtherInfoVO> selectTodayOtherCntRegion(){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 23);
        standard.set(Calendar.MINUTE, 59);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            now.add(Calendar.DATE, -1);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());

        return mapper.selectOtherCntRegion(dt);
    }
    public List<OtherInfoVO> selectOtherCntRegion(String date){
        return mapper.selectOtherCntRegion(date);
    }
    public List<OtherInfoVO> selectTodayOtherNeuterCnt(){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 23);
        standard.set(Calendar.MINUTE, 59);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            now.add(Calendar.DATE, -1);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());

        return mapper.selectOtherNeuterCnt(dt);
    }
    public List<OtherInfoVO> selectOtherNeuterCnt(String date){
        return mapper.selectOtherNeuterCnt(date);
    }
    public List<OtherInfoVO> selectTodayMonthOtherCnt(){
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 23);
        standard.set(Calendar.MINUTE, 59);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()){
            now.add(Calendar.DATE, -1);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());

        return mapper.selectMonthOtherCnt(dt);
    }
    public List<OtherInfoVO> selectMonthOtherCnt(String date){
        return mapper.selectMonthOtherCnt(date);
    }
}
