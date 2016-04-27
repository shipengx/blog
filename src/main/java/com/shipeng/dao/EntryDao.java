package com.shipeng.dao;

import java.util.List;
import com.shipeng.model.*;

public interface EntryDao {
	
	public void saveOrUpdate(Entry entry);
	public void delete(int entryId);
	public Entry getEntryById(int entryId);
	public List<Entry> listEntry();
	
}//end interface



