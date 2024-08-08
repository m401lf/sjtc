package com.automationteststore.pages.general;


import exception.TableRowDoesNotExistException;

import java.util.Map;

public interface TablePage {

    void assertCorrectTableContents(Map<String, String> fieldDataFromPage) throws TableRowDoesNotExistException;
}
