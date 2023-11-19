package com.example.datn.Service;

import com.example.datn.Entity.ChatLieu;
import com.example.datn.Exception.ChatLieuNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ChatLieuService {
    List<ChatLieu> getAllChatLieu();
    public static final int MATERIALS_PER_PAGE = 4;

    public List<ChatLieu> getAllPaginationChatLieu();
    public Page<ChatLieu> listByPage(int pageNumber, String sortField, String sortDir, String keyword);

    public ChatLieu save(ChatLieu chatLieu);

    public ChatLieu get(Integer id) throws ChatLieuNotFoundException, Exception;

    public boolean checkUnique(Integer id, String ten);

    public void updateChatLieuEnabledStatus(Integer id, boolean enabled);
}
