package com.lgcns.ceda.common.service;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.http.HttpService;

@Service("CedaLoginService")
public class CedaLoginServiceImpl implements CedaLoginService{

	@Override
	public boolean getLoginResult(String id, String pwd) {
		// TODO Auto-generated method stub
		
//		String path = this.getClass().getResource("CedaClientManualServiceImpl.class").getPath();
			
			if(id.equals("admin") && pwd.equals("admin")) {
				return true;
			}else {
				return false;
			}
//			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
//			Document document = builder.parse(new File(path+"/config/smart-contract.xml"));
//			
//			NodeList eNodeInfoList = document.getElementsByTagName("nodeInfo");							// ethereum node info
//			NodeList accountsNodeList = document.getElementsByTagName("AccountsContract");				// accounts contract info
//			NodeList serverAccountNodeList = document.getElementsByTagName("");							// server account info
//			Node eNode = eNodeInfoList.item(0);
//			Node accountsNode = accountsNodeList.item(0);
//			
//			if(accountsNode.getNodeType() == Node.ELEMENT_NODE) {
//				//contract address
//				Element element = (Element)accountsNode;
//				String contractAddress = element.getElementsByTagName("address").item(0).getTextContent();
//				
//				//connect private nodes
//				element = (Element)eNode;
//				String nodePath = "http://"+element.getElementsByTagName("node1").item(0).getTextContent()+":"+element.getElementsByTagName("port").item(0).getTextContent();
//				Web3j web = Web3j.build(new HttpService(nodePath));
//				
//				//server accounts
//				Credentials credentials = WalletUtils.loadCredentials("", "");
//			}
			
//		} catch (ParserConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SAXException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (CipherException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
