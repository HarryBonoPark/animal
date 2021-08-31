package com.greenart.api;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.greenart.service.CenterInfoService;
import com.greenart.vo.CenterInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@RestController
public class CenterAPIController {
    @Autowired
    CenterInfoService service;

    @GetMapping("/api/center")
    public Map<String, Object> getCareCenterInfo() throws Exception {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        StringBuilder urlBuilder = new StringBuilder("http://openapi.animal.go.kr/openapi/service/rest/animalShelterSrvc/shelterInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=FVm2RjOykHRLs6b5caz%2FuG2F9lBc1o2FrwfILXc3G2kEk2i8fJEMUljI95nRVGfG6WHyfA1S1rQYpCH5bDVTTw%3D%3D&"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("500", "UTF-8")); /*페이지당 보여줄 개수*/
        
        DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(urlBuilder.toString());

        doc.getDocumentElement().normalize();
        System.out.println(doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("item");
        System.out.println("데이터 수 : "+nList.getLength());

        for(int i=0; i<nList.getLength(); i++) {
            Node n = nList.item(i);
            Element elem = (Element) n;

            CenterInfoVO vo = new CenterInfoVO();

            String careNm = getTagValue("careNm", elem);
            String orgNm = getTagValue("orgNm", elem);
            String divisionNm = getTagValue("divisionNm", elem);
            String saveTrgtAnimal = getTagValue("saveTrgtAnimal", elem);
            String careAddr = getTagValue("careAddr", elem);
            String jibunAddr = getTagValue("jibunAddr", elem);
            String lat = getTagValue("lat", elem);
            String lng = getTagValue("lng", elem);
            String dsignationDate = getTagValue("dsignationDate", elem);
            String weekOprStime = getTagValue("weekOprStime", elem);
            String weekOprEtime = getTagValue("weekOprEtime", elem);
            String weekCellStime = getTagValue("weekCellStime", elem);
            String weekCellEtime = getTagValue("weekCellEtime", elem);
            String weekendOprStime = getTagValue("weekendOprStime", elem);
            String weekendOprEtime = getTagValue("weekendOprEtime", elem);
            String weekendCellStime = getTagValue("weekendCellStime", elem);
            String weekendCellEtime = getTagValue("weekendCellEtime", elem);
            String closeDay = getTagValue("closeDay", elem);
            String vetPersonCnt = getTagValue("vetPersonCnt", elem);
            String specsPersonCnt = getTagValue("specsPersonCnt", elem);
            String medicalCnt = getTagValue("medicalCnt", elem);
            String breedCnt = getTagValue("breedCnt", elem);
            String quarabtineCnt = getTagValue("quarabtineCnt", elem);
            String feedCnt = getTagValue("feedCnt", elem);
            String transCarCnt = getTagValue("transCarCnt", elem);
            String careTel = getTagValue("careTel", elem);
            String dataStdDt = getTagValue("dataStdDt", elem);

            // 동물 보호센터 지정 일자
            Date dDt = new Date();
            SimpleDateFormat dFormatter = new SimpleDateFormat("yyyyMMdd");
            dDt = dFormatter.parse(dsignationDate==null?"00000000":dsignationDate);

            // 데이터 기준 일자
            Date sDt = new Date();
            SimpleDateFormat sFormatter = new SimpleDateFormat("yyyyMMdd");
            sDt = sFormatter.parse(dataStdDt==null?"00000000":dataStdDt);

            vo.setCareNm(careNm);
            vo.setOrgNm(orgNm);
            vo.setDivisionNm(divisionNm);
            vo.setSaveTrgtAnimal(saveTrgtAnimal);
            vo.setCareAddr(careAddr);
            vo.setJibunAddr(jibunAddr);
            vo.setLat(Double.parseDouble(lat==null?"0":lat));
            vo.setLng(Double.parseDouble(lng==null?"0":lng));
            vo.setDsignationDate(dDt);
            vo.setWeekOprStime(weekOprStime);
            vo.setWeekOprEtime(weekOprEtime);
            vo.setWeekCellStime(weekCellStime);
            vo.setWeekCellEtime(weekCellEtime);
            vo.setWeekendOprStime(weekendOprStime);
            vo.setWeekendOprEtime(weekendOprEtime);
            vo.setWeekendCellStime(weekendCellStime);
            vo.setWeekendCellEtime(weekendCellEtime);
            vo.setCloseDay(closeDay);
            vo.setVetPersonCnt(Integer.parseInt(vetPersonCnt==null?"0":vetPersonCnt));
            vo.setSpecsPersonCnt(Integer.parseInt(specsPersonCnt==null?"0":specsPersonCnt));
            vo.setMedicalCnt(Integer.parseInt(medicalCnt==null?"0":medicalCnt));
            vo.setBreedCnt(Integer.parseInt(breedCnt==null?"0":breedCnt));
            vo.setQuarabtineCnt(Integer.parseInt(quarabtineCnt==null?"0":quarabtineCnt));
            vo.setFeedCnt(Integer.parseInt(feedCnt==null?"0":feedCnt));
            vo.setTransCarCnt(transCarCnt);
            vo.setCareTel(careTel);
            vo.setDataStdDt(sDt);


            service.insertCenterInfo(vo);
        }
        return resultMap;
    }

    public static String getTagValue(String tag, Element elem) {
        if(elem.getElementsByTagName(tag).item(0) == null) return null; // NullPointerException 떴을 때 넣어주기
        NodeList nlList = elem.getElementsByTagName(tag).item(0).getChildNodes();
        if(nlList == null) return null;
        Node node = (Node) nlList.item(0);
        if(node == null) return null;
        return node.getNodeValue();
    }

    // 보호센터 지역별 검색
    @GetMapping("/api/center/region")
    public Map<String, Object> getAnimalCenterInfo(@RequestParam @Nullable String region) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        List<CenterInfoVO> list = service.selectCenterInfoByRegion(region);

        resultMap.put("status", true);
        resultMap.put("data", list);

        char[] c = region.toCharArray();
        region = "%"+c[0]+"%"+c[1]+"%"+c[2]+"%";

        return resultMap;
    }

    // 보호센터 총 개수
    @GetMapping("/api/center/cnt")
    public Map<String, Object> getCenterInfoCnt() {

        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
    
        CenterInfoVO data = null;

        data = service.selectCenterInfoCntAll();
    
        resultMap.put("status", true);
        resultMap.put("data", data);

        return resultMap;
    }

    // 보호센터 상세정보
    @GetMapping("/api/center/detail")
    public Map<String, Object> getCenterDetailInfoBySeq(@RequestParam Integer seq) throws Exception {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        CenterInfoVO vo = service.selectCenterInfoBySeq(seq);
    
        resultMap.put("status", true);
        resultMap.put("data", vo);

        return resultMap;
    }
        
}