package com.hps.july.sitedoc;

/**
 * Идентификаторы состояний модуля
 */
public interface APPStates
{
	/** Главная форма */
	int MAIN						=	1;
	/** Форма входа в систему */
	int LOGIN						=	2;
	/** Форма выхода из системы */
	int LOGOUT						=	3;

	/** Форма списка документов */
	int SiteDocListForm				=	11;
	/** Форма редактирования документа */
	int SiteDocForm					=	12;
	/** Форма списка для привязки документа к позициям */
	int SiteDocPositionListForm		=	13;
	/** Форма списка для привязки документа к оборудованию */
	int SiteDocEquipmentListForm	=	14;
	/** Форма присоединения файла к документу */
	int SiteDocFileForm				=	15;
	/** Форма списка типов документа */
	int SiteDocTypeListForm			=	16;
	/** Форма редактирования типа документа */
	int SiteDocTypeForm				=	17;
	/** Форма списка для привязки документа к линиям связи */
	int SiteDocComlineListForm		=	18;

	int REGION_DOCUMENTS		=	34;
	
}
