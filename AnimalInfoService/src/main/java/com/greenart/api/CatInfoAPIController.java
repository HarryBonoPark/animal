package com.greenart.api;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.greenart.service.CatInfoService;
import com.greenart.vo.CatInfoVO;

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
public class CatInfoAPIController {
    @Autowired
    CatInfoService service;
    @GetMapping("/api/cat")
    public Map<String, Object> getCatInfo(
        @RequestParam String startDt, @RequestParam String endDt
    ) throws Exception {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        StringBuilder urlBuilder = new StringBuilder("http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=FVm2RjOykHRLs6b5caz%2FuG2F9lBc1o2FrwfILXc3G2kEk2i8fJEMUljI95nRVGfG6WHyfA1S1rQYpCH5bDVTTw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("bgnde","UTF-8") + "=" + URLEncoder.encode(startDt, "UTF-8")); /*유기날짜 (검색 시작일)*/
        urlBuilder.append("&" + URLEncoder.encode("endde","UTF-8") + "=" + URLEncoder.encode(endDt, "UTF-8")); /*유기날짜 (검색 종료일)*/
        urlBuilder.append("&" + URLEncoder.encode("upkind","UTF-8") + "=" + URLEncoder.encode("422400", "UTF-8"));  /*축종코드 - 개 : 417000 - 고양이 : 422400 - 기타 : 429900*/
        urlBuilder.append("&" + URLEncoder.encode("state","UTF-8") + "=" + URLEncoder.encode("null", "UTF-8")); /*상태 - 전체 : null(빈값) - 공고중 : notice - 보호중 : protect*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));  /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("50000", "UTF-8")); /*페이지당 보여줄 개수*/


        DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(urlBuilder.toString());

        doc.getDocumentElement().normalize();
        System.out.println(doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("item");
        System.out.println("데이터 수 : "+nList.getLength());

        for(int i=0; i<nList.getLength(); i++) {
            Node n = nList.item(i);
            Element elem = (Element)n;

            String age = getTagValue("age", elem);
            String careAddr = getTagValue("careAddr", elem);
            String careNm = getTagValue("careNm", elem);
            String careTel = getTagValue("careTel", elem);
            String colorCd = getTagValue("colorCd", elem);
            String desertionNo = getTagValue("desertionNo", elem);
            String filename = getTagValue("filename", elem);
            String happenDt = getTagValue("happenDt", elem);
            String happenPlace = getTagValue("happenPlace", elem);
            String kindCd = getTagValue("kindCd", elem);
            String neuterYn = getTagValue("neuterYn", elem);
            String noticeEdt = getTagValue("noticeEdt", elem);
            String noticeNo = getTagValue("noticeNo", elem);
            String noticeSdt = getTagValue("noticeSdt", elem);
            String officetel = getTagValue("officetel", elem);
            String orgNm = getTagValue("orgNm", elem);
            String popfile = getTagValue("popfile", elem);
            String processState = getTagValue("processState", elem);
            String sexCd = getTagValue("sexCd", elem);
            String specialMark = getTagValue("specialMark", elem);
            String weight = getTagValue("weight", elem);

            CatInfoVO vo = new CatInfoVO();
            Date hDt = new Date();
            SimpleDateFormat hFormatter = new SimpleDateFormat("yyyyMMdd");
            hDt = hFormatter.parse(happenDt);

            Date sDt = new Date();
            SimpleDateFormat sFormatter = new SimpleDateFormat("yyyyMMdd");
            sDt = sFormatter.parse(noticeSdt);

            Date eDt = new Date();
            SimpleDateFormat eFormatter = new SimpleDateFormat("yyyyMMdd");
            eDt = eFormatter.parse(noticeEdt);

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

            service.insertCatInfo(vo);
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

    @GetMapping("/api/cat/list")
    public Map<String, Object> getCatListInfo (@RequestParam @Nullable String region) throws Exception {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        List<CatInfoVO> list = service.selectCatInfo(region);

        resultMap.put("status", true);
        resultMap.put("catList", list);

        char[] c = region.toCharArray();
        region = "%"+c[0]+"%"+c[1]+"%"+c[2]+"%";

        return resultMap;
    }
    
    // 팝업 api
    @GetMapping("/api/cat/detail")
    public Map<String, Object> getCatDetailInfoBySeq(@RequestParam Integer seq) throws Exception {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        CatInfoVO vo = service.selectCatDetailInfoBySeq(seq);

        resultMap.put("status", true);
        resultMap.put("data", vo);

        return resultMap;
    }
}