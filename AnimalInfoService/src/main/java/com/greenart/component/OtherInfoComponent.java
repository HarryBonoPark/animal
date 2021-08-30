package com.greenart.component;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.greenart.service.OtherInfoService;
import com.greenart.vo.OtherInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class OtherInfoComponent {
    @Autowired OtherInfoService service;
    
    @Scheduled(cron="0 59 23 * * *")
    public void getOtherInfo() throws Exception{
        System.out.println("Other cron schedule");
        Date date= new Date();
        SimpleDateFormat dtFormat = new SimpleDateFormat("YYYYMMdd");
        String today = dtFormat.format(date);

        StringBuilder urlBuilder = new StringBuilder("http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=K646GgOj1V5gGoDig5IfrlUdY38yy%2BBfwM%2Bpo52YMu99%2FvnhaCoumBRcmO4vZtZzNn%2ByiL9JNTY0dyejqftagQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("bgnde","UTF-8") + "=" + URLEncoder.encode(today, "UTF-8")); /*유기날짜 (검색 시작일)*/
        urlBuilder.append("&" + URLEncoder.encode("endde","UTF-8") + "=" + URLEncoder.encode(today, "UTF-8")); /*유기날짜 (검색 종료일)*/
        urlBuilder.append("&" + URLEncoder.encode("upkind","UTF-8") + "=" + URLEncoder.encode("429900", "UTF-8"));  /*축종코드 - 개 : 417000 - 고양이 : 422400 - 기타 : 429900*/
        urlBuilder.append("&" + URLEncoder.encode("state","UTF-8") + "=" + URLEncoder.encode("null", "UTF-8")); /*상태 - 전체 : null(빈값) - 공고중 : notice - 보호중 : protect*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));  /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*페이지당 보여줄 개수*/

        DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(urlBuilder.toString());

        doc.getDocumentElement().normalize();
        System.out.println(doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("item");
        System.out.println("데이터 수 : "+nList.getLength());

        if(nList.getLength() <= 0){
            return;
        }
        
        for(int i=0; i<nList.getLength(); i++){
            Node n =nList.item(i);
            Element elem = (Element) n;

            OtherInfoVO vo = new OtherInfoVO();
            String age = getTagValue("age", elem); 
            //System.out.println(age);
            String careAddr = getTagValue("careAddr", elem); 
            //System.out.println(careAddr);
            String careNm = getTagValue("careNm", elem); 
            //System.out.println(careNm);
            String careTel = getTagValue("careTel", elem); 
            //System.out.println(careTel);
            String colorCd = getTagValue("colorCd", elem); 
            //System.out.println(colorCd);
            String desertionNo = getTagValue("desertionNo", elem); 
            //System.out.println(desertionNo);
            String filename = getTagValue("filename", elem);
            //System.out.println(filename); 
            String happenDt = getTagValue("happenDt", elem); 
            //System.out.println(happenDt);
            String happenPlace = getTagValue("happenPlace", elem); 
            //System.out.println(happenPlace);
            String kindCd = getTagValue("kindCd", elem); 
            //System.out.println(kindCd);
            String neuterYn = getTagValue("neuterYn", elem); 
            //System.out.println(neuterYn);
            String noticeSdt = getTagValue("noticeSdt", elem); 
            //System.out.println(noticeSdt);
            String noticeEdt = getTagValue("noticeEdt", elem);
            //System.out.println(noticeEdt); 
            String noticeNo = getTagValue("noticeNo", elem); 
            //System.out.println(noticeNo);
            String officetel = getTagValue("officetel", elem); 
            //System.out.println(officetel);
            String orgNm = getTagValue("orgNm", elem);
            //System.out.println(orgNm); 
            String popfile = getTagValue("popfile", elem);
            //System.out.println(popfile); 
            String processState = getTagValue("processState", elem);
            //System.out.println(processState); 
            String sexCd = getTagValue("sexCd", elem);
            //System.out.println(sexCd); 
            String specialMark = getTagValue("specialMark", elem);
            //System.out.println(specialMark); 
            String weight = getTagValue("weight", elem);
            //System.out.println(weight); 
            //System.out.println("================");

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

            //System.out.println(vo);

            service.insertOtherInfo(vo);
        }
    }
    public static String getTagValue(String tag, Element elem) {
        NodeList nlList = elem.getElementsByTagName(tag).item(0).getChildNodes();
        if(nlList == null) return null;
        Node node = (Node) nlList.item(0);
        if(node == null) return null;
        return node.getNodeValue();
    }
}
