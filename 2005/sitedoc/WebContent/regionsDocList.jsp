<%@ page language = "java" %>
<%@ page contentType = "TEXT/HTML; charset=windows-1251" %>
<%@ page import="java.util.*" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page import="com.hps.july.siteinfo.valueobject.*" %>
<%@ page import="com.hps.july.siteinfo.formbean.*" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/july.tld" prefix="july" %>

<%
	String ruser = request.getRemoteUser();
%>


<% java.lang.String gColSpan = "10"; %>


<style>
TABLE.main {font-size:8pt;}
TABLE.find {font-size:8pt;}
INPUT {font-size:8pt;}
SELECT {font-size:8pt;}
.editcheckbox {font-size:8pt;}
.editcheckboxform {font-size:8pt;}
.editcheckboxdisabled {font-size:8pt;}
.editkod {font-size:8pt;}
.editkodsearch {font-size:8pt;}
.editkoddisabled {font-size:8pt;}
.edit {font-size:8pt;}
.editsearch {font-size:8pt;width:152pt;}
.editdisabled {font-size:8pt;width:152pt;}
.editsmall {font-size:8pt;}
.diffeditsmall {font-size:8pt;}
.editsmallsearch {font-size:8pt;}
.edittini {font-size:8pt;}
.editsmalldisabled {font-size:8pt;}
.diffeditsmalldisabled {font-size:8pt;}
.editbig {font-size:8pt;}
.editbigsearch {font-size:8pt;}
.editbigdisabled {font-size:8pt;}
.editbigest {font-size:8pt;}
.editbigestsearch {font-size:8pt;}
.editbigestdisabled {font-size:8pt;}
INPUT.search {font-size:8pt;}
</style>

<script language="javascript">

function switchRenterSearch(state) {
	if(state) {
		document.all.renterSearchType.value = "<%= Position.RENTER_Any %>"
		PosForm.organization.className = 'editkoddisabled';
		PosForm.organization.disabled = true;
		document.all['lookupimg_r1l'].src='/images/lookup_disabled.gif';
	} else {
		document.all.renterSearchType.value = "<%= Position.RENTER_Specify %>"
		PosForm.organization.className = 'editkodsearch';
		PosForm.organization.disabled = false;
		document.all['lookupimg_r1l'].src='/images/lookup.gif';
	}
}
function switchAllSearch() {
	if(PosForm.searchBy.value=="A" ||
	   PosForm.searchBy.value=="F" ||
	   PosForm.searchBy.value=="G" ||
	   PosForm.searchBy.value=="H" ||
	   PosForm.searchBy.value=="K" ||
	   PosForm.searchBy.value=="L" ||
	   PosForm.searchBy.value=="M" 
	) {
		  PosForm.searchString.className = 'editdisabled';
		  PosForm.searchString.disabled = true;
	} else {
		PosForm.searchString.className = 'editsearch';
		PosForm.searchString.disabled = false;
	}
}

</script>

            <script language="JavaScript">
            <!--
                function getName() { return this.name; }
                function  getId() { return this.id; }
                function setName(name) { this.name = name; }
                function setId(id) { this.id = id; }
                function hasChilds() { return this.childs }
                function ValueObject(id, name, childs) {
                    this.name = name;
                    this.id = id;
                    this.childs = (childs == 1)?true:false;

                    this.getName = getName;
                    this.getId = getId;
                    this.setName = setName;
                    this.setId= setId;
                    this.hasChilds = hasChilds;
                }

            <%
                Collection arrays = (Collection)request.getAttribute("supregAndReg");
                if(arrays != null) {
                    for (Iterator iterator = arrays.iterator(); iterator.hasNext();) {
                        String array = (String)iterator.next();
                        %><%=array%><%
                    }
                }
            %>
            function createSuperRegionSelect() {
                //var supregionId = document.getElementById('supregion').value;

                var supreg = document.getElementById('supregions');
                var reg = document.getElementById('regions');
                //var zone = document.getElementById('zones');
                //var map = document.getElementById('maps');
                removeOptions(reg);
                //removeOptions(zone);
                for(i = 0; i < supregions.length; i++) {
                    var option = createOption(supregions[i]);
                    //if(supregionId && supregionId == supregions[i].getId()) {
                    //    var selected = document.createAttribute('selected');
                    //    selected.value = 'selected';
                    //    option.setAttributeNode(selected);
                    //}
                    supreg.appendChild(option);
                }

                //if(supregionId && supregionId != '') {
                //    createMapSelect(supreg);
                //    createRegionSelect(supreg);
                //    createZoneSelect(reg);
                //}
            }

            function createRegionSelect(supreg) {
                var reg = document.getElementById('regions');
                //var zone = document.getElementById('zones');
                //var map = document.getElementById('maps');
                removeOptions(reg); //delete regions
                //removeOptions(zone); //delete zones
                if(supreg.value == 0) return;
                var j = supreg.selectedIndex;
                var supregId = supreg.options[j].value;
                var result = regions[j];
                for(i = 0; i < result.length; i++) {
                    var option = createOption(result[i]);
                    //if(regionId && regionId != -1 && option.getAttribute('value') == regionId) {
                    //    document.mapList.regions.selectedIndex = i;
                    //}
                    reg.appendChild(option);
                }
            }

            function createZoneSelect(reg) {
                if(reg.value == 0) return;
                var zone = document.getElementById('zones');
                var map = document.getElementById('maps');
                var supreg = document.getElementById('supregions');
                var k1 = supreg.selectedIndex - 1;
                var j = reg.selectedIndex - 1;
                var result = zones[k1][j];
                removeOptions(zone);
                for(i = 0; i < result.length; i++) {
                    var option = createOption(result[i]);
                    if(zoneId && zoneId != -1 && option.getAttribute('value') == regionId) {
                        document.mapList.regions.selectedIndex = i;
                    }
                    zone.appendChild(option);
                }
            }

            function createMapSelect(supreg) {
                sendObject.region = supreg.options[supreg.selectedIndex].value;
                if(supreg.options[supreg.selectedIndex].value == 0) return;
                var mapId = document.getElementById('map').value;
                var map = document.getElementById('maps');
                removeOptions(map);

                var k1 = supreg.selectedIndex - 1;
                var result = maps[k1];
                for(i = 0; i < result.length; i++) {
                    var option = createOption(result[i]);
                    if(mapId && mapId == result[i].getId()) {
                        var selected = document.createAttribute('selected');
                        selected.value = 'selected';
                        option.setAttributeNode(selected);
                    }
                    map.appendChild(option);
                }
                if(result.length == 1) {
                    document.mapList.maps.selectedIndex = 1;
                }

            }

            function createOption(result) {
                var option = document.createElement("OPTION");
                var attr = document.createAttribute("value");
                var text = document.createAttribute("text");
                attr.value = result.getId();
                option.innerHTML = result.getName();
                option.setAttributeNode(attr);
                option.setAttributeNode(text);
                return option;
            }

            function removeOptions(sel) {
                var k = getOptionsCount(sel);
                for(i = 0; i < k; i++) {
                    var list = sel.childNodes;
                    for (var i1 = 0; i1 < list.length; i1++) {
                        if(list[i1].nodeName == 'OPTION') {
                            var m = list[i1].getAttribute('required');
                            if(!m) sel.removeChild(list[i1]);
                        }
                    }
                }
            }

            function getOptionsCount(sel) {
                var list = sel.childNodes;
                var count = 0;
                for (var i1 = 0; i1 < list.length; i1++) {
                    if(list[i1].nodeName == 'OPTION') {
                        count++;
                    }
                }
                return count;
            }

            function showDocuments(sel) {
                var sIndex = sel.selectedIndex;
                var type = (sel.id == 'supregions')?'region':'branch';
                var userName = '<%=request.getRemoteUser()%>';
                var id = sel.value;
                var url = ('<%=com.hps.july.util.AppUtils.getNamedValueString("TerrabyteURL")%>?st=1&type=' + type + '&id=' + id + '&uid=' + userName);
                //alert(url);
                //alert(sIndex + "=" + sel.value + "=" + type);

                //alert(document.getElementById('terraWin').src);
                document.getElementById('terraWin').src = url;
                //alert(document.getElementById('terraWin').src);

            }


            onload = function(e) {
                createSuperRegionSelect();
                var terraWin = document.getElementById('terraWin');
                var w = document.getElementById('separ');
                var h = document.getElementById('separH');
                if(w) w = (w.clientWidth - 15);
                if(h) h = (h.clientHeight - 130);
                if(terraWin) {
                    terraWin.width = w;
                    terraWin.height = h;
                }
            }

            -->
            </script>

<table class="main">
<july:separator colspan="<%= gColSpan %>" trid="separ"/>
<TR class="normal">
	<TD colspan="<%= gColSpan %>">
	<table class="find">
	<TR class='normal'>
		<td colspan="4">
		<table border=0 width="100%" cellpadding=0 cellspacing=0>
		<tr>
			<%-- td><jsp:include page="/common/shortRegSelect.jsp" flush="true" /></td --%>
			<td>
				<select id="supregions" src="" onchange="createRegionSelect(this); showDocuments(this);" style="width : 250px" size="3">
                </select>
			</td>
			<td>
				<select id="regions" onchange="showDocuments(this);" style="width : 250px" size="3">
                </select>
			</td>
<%--
			<td><july:searchbutton/></td>
--%>
		</tr>
		</table>
		</td>
	</TR>
	</table>
	</TD>
</TR>


<july:separator colspan="<%= gColSpan %>" />


<tr bgcolor="white" >
	<td colspan="<%= gColSpan %>" height="100%" width="100%">
	<TABLE width="100%" height="100%">
        <TR>
        <TD height="100%" width="100%" >
            <iframe id="terraWin" name="terraWin" src="/sitedoc/empty.jsp" scrolling="yes" frameborder="0" style="visibility:visible"  style="border-style : none;"></iframe>
        </TD>
        </TR></TABLE>
	</td>
</tr>

<july:separator colspan="<%= gColSpan %>" />

</table>

<%--html:hidden property="sortorder"/--%>
<script language="JavaScript">
	document.body.style.cursor="normal";
</script>



