<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>
<%@ taglib uri="/WEB-INF/alex1.tld"    prefix="alex" %>

<%@ page import="org.apache.struts.util.*,com.hps.july.basestation.formbean.*,
                 com.hps.july.jdbcpersistence.lib.*"%>
<%EquipmentListForm listForm=(EquipmentListForm) request.getAttribute("EquipmentListForm");%>
<script language="javascript">

function sortSelect(selectId,comp){

  var arrItems=new Array();


  for(var i = 0; i < document.all.item(selectId).length; i++){
  arrItems[i]=new Array();
    arrItems[i][0]=document.all.item(selectId).options[i].text;
    arrItems[i][1]=document.all.item(selectId).options[i].value;
    arrItems[i][2]=document.all.item(selectId).options[i].selected;

    }

  arrItems.sort(comp);

  for(var i = 0; i < document.all.item(selectId).length; i++){

    document.all.item(selectId).options[i].value=arrItems[i][1];
    document.all.item(selectId).options[i].text=arrItems[i][0];
    document.all.item(selectId).options[i].selected=arrItems[i][2];

    }
 }

function compForRegions(arg1,arg2){

if(arg2[2]==true&&arg1[2]==false){
 return 1
}else if(arg1[2]==true&&arg2[2]==false){
 return -1;
}

if(arg2[0] < arg1[0] )return 1;
else if(arg2[0] > arg1[0]) return  -1;
else return -0;
}
function selectItems(selectId, items ){
     var count = 0;
     if(items!=null){
        for(var j=0; j < items.length; j++){
           for(var i=0; i< document.all.item(selectId).length; i++){
              if(document.all.item(selectId)[i].value == items[j]){
                 document.all.item(selectId).options[i].selected = true;
                 count++;
              }
           }
        }
     }
     if( count == 0 && document.all.item(selectId).length>0)
        document.all.item(selectId).options[0].selected = true;
  }



function sortByName(arg1,arg2){

if(arg2[1]<arg1[1])return 1;
else if(arg2[1]>arg1[1])return  -1;
else return -0;
}

  function refreshSelectFromSelect(dependSelect, mainSelect, data ){
     var prodWork = new Array();

     var n = 0;
     var count = 0;
     for(var i = 0; i < data.length; i++){
        if(document.all.item(mainSelect).options[i].selected){
               count++;
               for(var j = n; j < n + data[i].length ; j++){
              prodWork[j]= data[i][j-n];
                   }
                   n += data[i].length;
            }
     }


     prodWork.sort(sortByName);
     document.all.item(dependSelect).length = prodWork.length;

     for(var i = 0; i < prodWork.length; i++){
         document.all.item(dependSelect)[i].text = prodWork[i][1];
             document.all.item(dependSelect)[i].value = prodWork[i][0];
     }
  }



  function initSelectFromCheckbox( selectId,checkboxId){

    var eName;
    var dName;
    if(false&&selectId=='sel_netzones'){
      eName='editsearch';
      dName='editdisabled';
    }else{
      eName='editsmallsearch';
      dName='editsmalldisabled';
    }


       if(document.all.item(checkboxId).checked){
          document.all.item(selectId).disabled = true;
          document.all.item(selectId).className = dName;
          if(document.all.item(checkboxId).checked){
              for(var i = 0; i < document.all.item(selectId).length; i++){
                 document.all.item(selectId).options[i].selected = true;
              }
         }

       }else {

         document.all.item(selectId).disabled = false;
         document.all.item(selectId).className = eName;
      }
document.all.item(selectId).style.width='160pt';

  }



  function refreshSelectFromCheckbox( selectId,checkboxId){

    var eName;
    var dName;
    if(false&&selectId=='sel_netzones'){
      eName='editsearch';
      dName='editdisabled';
    }else{
      eName='editsmallsearch';
      dName='editsmalldisabled';
    }


       if(document.all.item(checkboxId).checked){

                   for(var i = 0; i < document.all.item(selectId).length; i++){
                     document.all.item(selectId).options[i].selected = true;
                   }
                   document.all.item(selectId).disabled = true;
                   document.all.item(selectId).className = dName;

       }else {
     //    document.all.item(selectId).disabled = false;
         document.all.item(selectId).className = eName;
                   if(document.all.item(selectId).length > 0){
                     document.all.item(selectId).options[0].selected = true;
                   }
                   for(var i = 1; i < document.all.item(selectId).length; i++){
                      document.all.item(selectId).options[i].selected = false;
                   }
         document.all.item(selectId).disabled = false;
      //   document.all.item(selectId).className = eName;
      }

 document.all.item(selectId).style.width='160pt';
  }


  function refreshCheckboxFromSelect( ch, sel){

     if(document.all.item(sel).length == 0){
        document.all.item(ch).checked = false;
            document.all.item(ch).disabled = true;
     }
     else
        document.all.item(ch).disabled = false;

}
</script>

<TR class='normal'>

<td colspan="4">

<table class='find'  >
<tr>



<td class="title" >
<bean:message key="label.position.search.supregs"/>
<july:checkbox property="isAllSupregs" styleId="check_supregs" insertable="true" updatable="true"
  onclick="refreshSelectFromCheckbox( 'sel_supregs','check_supregs');refreshSelectFromSelect('sel_regions', 'sel_supregs', data);refreshCheckboxFromSelect('check_regions', 'sel_regions');refreshSelectFromCheckbox( 'sel_regions','check_regions');"/>
<bean:message key="label.search.all"/>
</td>

<td class="title" >
<bean:message key="label.position.search.regions"/>
<july:checkbox property="isAllRegions" styleId="check_regions" insertable="true" updatable="true"
  onclick="refreshSelectFromCheckbox( 'sel_regions','check_regions');" />
<bean:message key="label.search.all"/>
</td>
<td class="title"  >
<bean:message key="label.position.netzonename"/>
 <july:checkbox property="isAllNetZones" styleId="isNetZoneCh" insertable="true" updatable="true" onclick="refreshSelectFromCheckbox('sel_netzones','isNetZoneCh');" />
<bean:message key="label.search.all"/>
</td>
<td class="title" align='right'><july:searchbutton/></td>
</TR>


<TR>

<td class="title" >

<july:select collection="supregs" property="supregcodes" insertable="true" updatable="true" styleId="sel_supregs" multiple="true" size='3' styleClass="editsmallsearch"
  onchange="refreshSelectFromSelect('sel_regions', 'sel_supregs', data);refreshCheckboxFromSelect('check_regions', 'sel_regions');refreshSelectFromCheckbox( 'sel_regions','check_regions');">
   <html:options collection="supregs" property="id" labelProperty="name"/>
</july:select>

</td>

<td class="title" >



<july:select collection="regions" property="regioncodes" insertable="true" updatable="true" styleId="sel_regions" multiple="true" size='3' styleClass="editsmallsearch">
   <html:options collection="regions" property="id" labelProperty="name"/>
</july:select>

<script language="javascript">
<%=
SuperRegionObject.createViewSelectData("data",listForm.getSupregs().elements(),request.getRemoteUser(),new Boolean(request.isUserInRole("administrator")))
%>
<%=
RegionObject.createSelectItems("items", listForm.getRegioncodes())
%>
  initSelectFromCheckbox( "sel_supregs","check_supregs");
   refreshSelectFromSelect("sel_regions", "sel_supregs", data);
   selectItems("sel_regions", items );
   refreshCheckboxFromSelect("check_regions", "sel_regions");
    initSelectFromCheckbox( "sel_regions","check_regions");
    sortSelect("sel_regions",compForRegions);
</script>
</td>
<td class="title"  >

<july:select collection="netzones" property="netzonecodes" insertable="true" updatable="true" styleId="sel_netzones" styleClass="editsmallsearch" multiple="true"  size='3'>
        <html:options collection="netzones" property="netzone" labelProperty="name"/>
</july:select>
<script language="javascript">
       initSelectFromCheckbox('sel_netzones','isNetZoneCh');
</script>
</td>
<td>&nbsp;</td>
</TR>

</table>
</td>

</TR>