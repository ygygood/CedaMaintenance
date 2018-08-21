package com.lgcns.ceda.manual.service;

import java.util.ArrayList;

import com.lgcns.ceda.dataset.ClientInfo;

public interface CedaClientManualService {
	public ArrayList<ClientInfo> getClientInfo(ArrayList<String> keywordList);
}
