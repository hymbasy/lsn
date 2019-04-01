package com.alex.service;

import java.util.Map;

public interface HistoryService {
    void save2Redis(Map<String, String> param);
}
