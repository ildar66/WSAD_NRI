package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * ����� ������ � ������������� ����������
 */
public class MassdocForm extends ReportForm {
public MassdocForm() {
}
public int getState() {
	return com.hps.july.inventory.APPStates.MASSDOC;
}
}
