package com.greenart.api;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.greenart.service.AnimalInfoService;
import com.greenart.vo.AnimalInfoVO;
import com.greenart.vo.CatInfoVO;
import com.greenart.vo.OtherInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@RestController
public class AnimalAPIController {
    @Autowired AnimalInfoService service;

    @GetMapping("/api/animal")
    public Map<String, Object> getAnimalHomeInfo(@RequestParam String startDt, @RequestParam String endDt) throws Exception {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        StringBuilder urlBuilder = new StringBuilder("http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=FVm2RjOykHRLs6b5caz%2FuG2F9lBc1o2FrwfILXc3G2kEk2i8fJEMUljI95nRVGfG6WHyfA1S1rQYpCH5bDVTTw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("bgnde","UTF-8") + "=" + URLEncoder.encode(startDt, "UTF-8")); /*유기날짜 (검색 시작일)*/
        urlBuilder.append("&" + URLEncoder.encode("endde","UTF-8") + "=" + URLEncoder.encode(endDt, "UTF-8")); /*유기날짜 (검색 종료일)*/
        urlBuilder.append("&" + URLEncoder.encode("upkind","UTF-8") + "=" + URLEncoder.encode("417000", "UTF-8"));  /*축종코드 - 개 : 417000 - 고양이 : 422400 - 기타 : 429900*/
        urlBuilder.append("&" + URLEncoder.encode("state","UTF-8") + "=" + URLEncoder.encode("null", "UTF-8")); /*상태 - 전체 : null(빈값) - 공고중 : notice - 보호중 : protect*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));  /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("52890", "UTF-8")); /*페이지당 보여줄 개수*/


        DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(urlBuilder.toString());

        doc.getDocumentElement().normalize();
        System.out.println(doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("item");
        System.out.println("데이터 수 : "+nList.getLength());
        if(nList.getLength() <= 0){
            return resultMap;
        }
        for(int i=0; i<nList.getLength(); i++) {
            Node n = nList.item(i);
            Element elem = (Element) n;
            
            AnimalInfoVO vo = new AnimalInfoVO();
            String age = getTagValue("age", elem);
            System.out.println("나이 : "+age);
            String careAddr = getTagValue("careAddr", elem);
            System.out.println("보호 장소 : "+careAddr);
            String careNm = getTagValue("careNm", elem);
            System.out.println("보호소 이름 : "+careNm);
            String careTel = getTagValue("careTel", elem);
            System.out.println("보호소 전화번호 : "+careTel);
            // String chargeNm = getTagValue("chargeNm", elem);
            // System.out.println("담당자 : "+chargeNm);
            String colorCd = getTagValue("colorCd", elem);
            System.out.println("색상 : "+colorCd);
            String desertionNo = getTagValue("desertionNo", elem);
            System.out.println("유기번호 : "+desertionNo);
            String filename = getTagValue("filename", elem);
            System.out.println("Thumbnail Image :"+filename);
            String happenDt = getTagValue("happenDt", elem);
            System.out.println("접수일 : "+happenDt);
            String happenPlace = getTagValue("happenPlace", elem);
            System.out.println("발견 장소 : "+happenPlace);
            String kindCd = getTagValue("kindCd", elem);
            System.out.println("품종 : "+kindCd);
            String neuterYn = getTagValue("neuterYn", elem);
            System.out.println("중성화 여부 : "+neuterYn);
            String noticeEdt = getTagValue("noticeEdt", elem);
            System.out.println("공고 종료일 : "+noticeEdt);
            String noticeNo = getTagValue("noticeNo", elem);
            System.out.println("공고 번호 : "+noticeNo);
            String noticeSdt = getTagValue("noticeSdt", elem);
            System.out.println("공고 시작일 : "+noticeSdt);
            String officetel = getTagValue("officetel", elem);
            System.out.println("담당자 연락처 : "+officetel);
            String orgNm = getTagValue("orgNm", elem);
            System.out.println("관할기관 : "+orgNm);
            String popfile = getTagValue("popfile", elem);
            System.out.println("이미지 : "+popfile);
            String processState = getTagValue("processState", elem);
            System.out.println("상태 : "+processState);
            String sexCd = getTagValue("sexCd", elem);
            System.out.println("성별 : "+sexCd);
            String specialMark = getTagValue("specialMark", elem);
            System.out.println("특징 : "+specialMark);
            String weight = getTagValue("weight", elem);
            System.out.println("체중(Kg) : "+weight);
            System.out.println("====================================================================");

            Date hDt = new Date();
            SimpleDateFormat hFormatter = new SimpleDateFormat("yyyyMMdd");
            hDt = hFormatter.parse(happenDt);

            Date eDt = new Date();
            SimpleDateFormat eFormatter = new SimpleDateFormat("yyyyMMdd");
            eDt = eFormatter.parse(noticeEdt);

            Date sDt = new Date();
            SimpleDateFormat sFormatter = new SimpleDateFormat("yyyyMMdd");
            sDt = sFormatter.parse(noticeSdt);

            vo.setAge(age);
            vo.setCareAddr(careAddr);
            vo.setCareNm(careNm);
            vo.setCareTel(careTel);
            // vo.setChargeNm(chargeNm);
            vo.setColorCd(colorCd);
            vo.setDesertionNo(desertionNo);
            vo.setFilename(filename);
            vo.setHappenDt(hDt);
            vo.setHappenPlace(happenPlace);
            vo.setKindCd(kindCd);
            vo.setNeuterYn(neuterYn);
            vo.setNoticeEdt(eDt);
            vo.setNoticeNo(noticeNo);
            vo.setNoticeSdt(sDt);
            vo.setOfficetel(officetel);
            vo.setOrgNm(orgNm);
            vo.setPopfile(popfile);
            vo.setProcessState(processState);
            vo.setSexCd(sexCd);
            vo.setSpecialMark(specialMark);
            vo.setWeight(weight);

            // System.out.println(vo);

            service.insertAnimalInfo(vo);
        }
        
        return resultMap;
    }

    public static String getTagValue(String tag, Element elem) {
        NodeList nlList = elem.getElementsByTagName(tag).item(0).getChildNodes();
        if(nlList == null) return null;
        Node node = (Node) nlList.item(0);
        if(node == null) return null;
        return node.getNodeValue();
    }

    @GetMapping("/api/sexInfo/{date}")
    public Map<String, Object> getSexInfoDate(@PathVariable String date){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        if(date.equals("today")){
            List<AnimalInfoVO> list = service.selectTodaySexAnimalCnt();
            resultMap.put("data", list);
        } else {
            List<AnimalInfoVO> list = service.selectSexAnimalInfo(date);
            resultMap.put("data", list);
        }
        return resultMap;
    }

    @GetMapping("/api/regionInfo/{date}")
    public Map<String, Object> getRegionInfoDate(@PathVariable String date){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        if(date.equals("today")){
            List<AnimalInfoVO> list = service.selectTodayCntRegion();
            resultMap.put("data", list);
        } else {
            List<AnimalInfoVO> list = service.selectCntRegion(date);
            resultMap.put("data", list);
        }
        return resultMap;
    }

    @GetMapping("/api/neuter/{date}")
    public Map<String, Object> getNeuterDate(@PathVariable String date){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        if(date.equals("today")){
            List<AnimalInfoVO> list = service.selectTodayNeuterCnt();
            resultMap.put("data", list);
        } else {
            List<AnimalInfoVO> list = service.selectNeuterCnt(date);
            resultMap.put("data", list);
        }
        return resultMap;
    }



    // CAT
    @GetMapping("/api/catSexInfo/{date}")
    public Map<String, Object> getCatSexInfoDate(@PathVariable String date){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        if(date.equals("today")){
            List<CatInfoVO> list = service.selectTodayCatSexAnimalCnt();
            resultMap.put("data", list);
        } else {
            List<CatInfoVO> list = service.selectCatSexAnimalCnt(date);
            resultMap.put("data", list);
        }
        return resultMap;
    }

    @GetMapping("/api/catRegionInfo/{date}")
    public Map<String, Object> getCatRegionInfoDate(@PathVariable String date){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        if(date.equals("today")){
            List<CatInfoVO> list = service.selectTodayCatCntRegion();
            resultMap.put("data", list);
        } else {
            List<CatInfoVO> list = service.selectCatCntRegion(date);
            resultMap.put("data", list);
        }
        return resultMap;
    }

    @GetMapping("/api/catNeuter/{date}")
    public Map<String, Object> getCatNeuterDate(@PathVariable String date){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        if(date.equals("today")){
            List<CatInfoVO> list = service.selectTodayCatNeuterCnt();
            resultMap.put("data", list);
        } else {
            List<CatInfoVO> list = service.selectCatNeuterCnt(date);
            resultMap.put("data", list);
        }
        return resultMap;
    }

    @GetMapping("/api/month/{date}")
    public Map<String, Object> getMonthDate(@PathVariable String date){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        if(date.equals("today")){
            List<AnimalInfoVO> d_list = service.selectTodayMonthDogCnt();
            List<CatInfoVO> c_list = service.selectTodayMonthCatCnt();
            List<OtherInfoVO> o_list = service.selectTodayMonthOtherCnt();
            resultMap.put("d_data", d_list);
            resultMap.put("c_data", c_list);
            resultMap.put("o_data", o_list);
        } else {
            List<AnimalInfoVO> d_list = service.selectMonthDogCnt(date);
            List<CatInfoVO> c_list = service.selectMonthCatCnt(date);
            List<OtherInfoVO> o_list = service.selectTodayMonthOtherCnt();
            resultMap.put("d_data", d_list);
            resultMap.put("c_data", c_list);
            resultMap.put("o_data", o_list);
        }
        return resultMap;
    }

    @GetMapping("/api/dogState/{date}")
    public  Map<String, Object> getDogStateDate(@PathVariable String date){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        if(date.equals("today")){
            List<AnimalInfoVO> list = service.selectTodayDogProcessState();
            resultMap.put("data", list);
        } else {
            List<AnimalInfoVO> list = service.selectDogProcessState(date);
            resultMap.put("data", list);
        }
        return resultMap;
    }
    @GetMapping("/api/catState/{date}")
    public  Map<String, Object> getCatStateDate(@PathVariable String date){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        if(date.equals("today")){
            List<CatInfoVO> list = service.selectTodayCatProcessState();
            resultMap.put("data", list);
        } else {
            List<CatInfoVO> list = service.selectCatProcessState(date);
            resultMap.put("data", list);
        }
        return resultMap;
    }




    // OTHER
    @GetMapping("/api/otherSexInfo/{date}")
    public Map<String, Object> getOtherSexInfoDate(@PathVariable String date){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        if(date.equals("today")){
            List<OtherInfoVO> list = service.selectTodayOtherSexAnimalCnt();
            resultMap.put("data", list);
        } else {
            List<OtherInfoVO> list = service.selectOtherSexAnimalCnt(date);
            resultMap.put("data", list);
        }
        return resultMap;
    }

    @GetMapping("/api/otherRegionInfo/{date}")
    public Map<String, Object> getotherRegionInfoDate(@PathVariable String date){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        if(date.equals("today")){
            List<OtherInfoVO> list = service.selectTodayOtherCntRegion();
            resultMap.put("data", list);
        } else {
            List<OtherInfoVO> list = service.selectOtherCntRegion(date);
            resultMap.put("data", list);
        }
        return resultMap;
    }

    @GetMapping("/api/otherNeuter/{date}")
    public Map<String, Object> getOtherNeuterDate(@PathVariable String date){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        if(date.equals("today")){
            List<OtherInfoVO> list = service.selectTodayOtherNeuterCnt();
            resultMap.put("data", list);
        } else {
            List<OtherInfoVO> list = service.selectOtherNeuterCnt(date);
            resultMap.put("data", list);
        }
        return resultMap;
    }
}
