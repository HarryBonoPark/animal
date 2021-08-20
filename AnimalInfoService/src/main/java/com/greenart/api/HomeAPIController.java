package com.greenart.api;

import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@RestController
public class HomeAPIController {
    @GetMapping("/api/home")
    public Map<String, Object> getAnimalHome() throws Exception{
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        StringBuilder urlBuilder = new StringBuilder("http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=FVm2RjOykHRLs6b5caz%2FuG2F9lBc1o2FrwfILXc3G2kEk2i8fJEMUljI95nRVGfG6WHyfA1S1rQYpCH5bDVTTw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("bgnde","UTF-8") + "=" + URLEncoder.encode("20140601", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("endde","UTF-8") + "=" + URLEncoder.encode("20210819", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("upkind","UTF-8") + "=" + URLEncoder.encode("417000", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("state","UTF-8") + "=" + URLEncoder.encode("notice", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("50000", "UTF-8")); /*한 페이지 결과 수*/
        // urlBuilder.append("&" + URLEncoder.encode("neuter_yn","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); 

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(urlBuilder.toString());

        doc.getDocumentElement().normalize();
        System.out.println(doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("item");
        System.out.println("size : "+nList.getLength());
        if(nList.getLength() <= 0){
            resultMap.put("status", false);
            resultMap.put("message", "데이터가 없습니다.");
            return resultMap;
        }
        for(int i=0; i<nList.getLength(); i++){
            // 순차조회
            Node node =nList.item(i);
            Element elem = (Element) node;

            System.out.println(getTagValue("age", elem));
            System.out.println(getTagValue("careAddr", elem));
            System.out.println(getTagValue("careNm", elem));
            System.out.println(getTagValue("careTel", elem));
            System.out.println(getTagValue("filename", elem));
            System.out.println(getTagValue("chargeNm", elem));
            System.out.println(getTagValue("colorCd", elem));
            System.out.println(getTagValue("desertionNo", elem));
            System.out.println(getTagValue("happenDt", elem));
            System.out.println(getTagValue("happenPlace", elem));
            System.out.println(getTagValue("kindCd", elem));
            System.out.println(getTagValue("neuterYn", elem));
            System.out.println(getTagValue("noticeEdt", elem));
            System.out.println(getTagValue("noticeNo", elem));
            System.out.println(getTagValue("noticeSdt", elem));
            System.out.println(getTagValue("officetel", elem));
            System.out.println(getTagValue("orgNm", elem));
            System.out.println(getTagValue("popfile", elem));
            System.out.println(getTagValue("processState", elem));
            System.out.println(getTagValue("sexCd", elem));
            System.out.println(getTagValue("specialMark", elem));
            System.out.println(getTagValue("weight", elem));
            System.out.println("==============================================");

            // CoronaInfoVO vo = new CoronaInfoVO();
            // vo.setAccExamCnt(Integer.parseInt(getTagValue("accExamCnt", elem))); // 누적 검사 수
            // vo.setAccExamCompCnt(Integer.parseInt(getTagValue("accExamCompCnt", elem))); // 누적 검사완료 수
            // vo.setCareCnt(Integer.parseInt(getTagValue("careCnt", elem))); // 치료 중
            // vo.setClearCnt(Integer.parseInt(getTagValue("clearCnt", elem))); // 격리 해제
            // vo.setDeathCnt(Integer.parseInt(getTagValue("deathCnt", elem))); // 사망자 수
            // vo.setDecideCnt(Integer.parseInt(getTagValue("decideCnt", elem))); // 확진
            // vo.setExamCnt(Integer.parseInt(getTagValue("examCnt", elem))); // 검사진행 수
            // vo.setResultNegCnt(Integer.parseInt(getTagValue("resutlNegCnt", elem))); // 음성
            // // String to Date
            // Date dt = new Date();
            // SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // dt = dtFormat.parse(getTagValue("createDt", elem));

            // vo.setStateTime(dt); // 기준시간

            // // System.out.println(vo);
            // service.insertCoronaInfo(vo);
        }
        resultMap.put("status", true);
        resultMap.put("message", "데이터가 입력되었습니다.");
        return resultMap;
    }

    public static String getTagValue(String tag, Element elem){
        NodeList nlList = elem.getElementsByTagName(tag).item(0).getChildNodes();
        if(nlList == null) return null;
        Node node = (Node) nlList.item(0);
        if(node == null) return null;
        return node.getNodeValue();
    }
}
