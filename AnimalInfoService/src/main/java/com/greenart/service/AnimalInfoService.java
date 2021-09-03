package com.greenart.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
        // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // String dt = formatter.format(now.getTime());

        AnimalInfoVO data = mapper.selectAllCntByDate();
        Integer noCnt = data.getNoCnt();

        DecimalFormat dFormatter = new DecimalFormat("###,###");
        String strAllCnt = dFormatter.format(noCnt);

        data.setStrAllCnt(strAllCnt);

        return data;

    }
    public AnimalInfoVO selectAllCntByDate(){
        return mapper.selectAllCntByDate();
    }

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
    }

    public List<AnimalInfoVO> selectDogProcessState(String date){
        return mapper.selectDogProcessState(date);
}




// CAT
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
        // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // String dt = formatter.format(now.getTime());

        CatInfoVO data = mapper.selectAllCatCntByDate();
        Integer noCnt = data.getC_noCnt();

        DecimalFormat dFormatter = new DecimalFormat("###,###");
        String strAllCnt = dFormatter.format(noCnt);

        data.setC_strAllCnt(strAllCnt);

        return data;
    }
    public CatInfoVO selectAllCatCntByDate(){
        return mapper.selectAllCatCntByDate();
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
        // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // String dt = formatter.format(now.getTime());

        OtherInfoVO data = mapper.selectAllOtherCntByDate();
        Integer noCnt = data.getO_noCnt();

        DecimalFormat dFormatter = new DecimalFormat("###,###");
        String strAllCnt = dFormatter.format(noCnt);

        data.setO_strAllCnt(strAllCnt);

        return data;
    }
    public OtherInfoVO selectAllOtherCntByDate(){
        return mapper.selectAllOtherCntByDate();
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
