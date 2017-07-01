package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма печати этикетки со штрих кодом
 */
public class BarReportForm
	extends ReportForm
{
public BarReportForm() {
}
public int getState() {
	return com.hps.july.inventory.APPStates.BARPRINT;
}
}
