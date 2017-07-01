<SCRIPT language="javascript">
	function getSubtypeSelected() {
		subtypeSelected(document.all.islinear.value);
	}

	function subtypeSelected(index) {
  		switch (index) {
  			case "true": {
				document.all.bandwidthFrm.disabled = false;
				document.all.bandwidthFrm.className = 'edit';
				document.all.endbandwidthFrm.disabled = false;
				document.all.endbandwidthFrm.className = 'edit';
				document.all.numchanalsFrm.disabled = true;
				document.all.numchanalsFrm.className = 'editdisabled';
				break;
	  		}
  			case "false": {
				document.all.bandwidthFrm.disabled = true;
				document.all.bandwidthFrm.className = 'editdisabled';
				document.all.endbandwidthFrm.disabled = true;
				document.all.endbandwidthFrm.className = 'editdisabled';
				document.all.numchanalsFrm.disabled = false;
				document.all.numchanalsFrm.className = 'edit';
				break;
  			}
	  	}
	}
	
	function subtypeSelectedVis(index) {
  		switch (index) {
  			case "1": {
				document.all.bwfrm.style.display = 'block';
				document.all.bwfrm.style.visibility = 'visible';
				document.all.bwefrm.style.display = 'block';
				document.all.bwefrm.style.visibility = 'visible';
				document.all.ncfrm.style.display = 'none';
				document.all.ncfrm.style.visibility = 'hidden';
				break;
	  		}
	  		case "2": {
				document.all.bwfrm.style.display = 'none';
				document.all.bwfrm.style.visibility = 'hidden';
				document.all.bwefrm.style.display = 'none';
				document.all.bwefrm.style.visibility = 'hidden';
				document.all.ncfrm.style.display = 'block';
				document.all.ncfrm.style.visibility = 'visible';
				break;
	  		}
	  	}
	}
	
	function getReptypeSelected() {
		reptypeSelected(document.all.repitertypeFrm.value);
	}
	
	function reptypeSelected(index) {
  		switch (index) {
  			case "1": {
  				//setVisibleStraight(true);
				setVisibleFreqcarry(false);
				setVisibleDigital(false);
				setVisibleOptical(false);
	  			break;
	  		}
	  		case "2": {
	  			setVisibleStraight(false);
				setVisibleFreqcarry(true);
				setVisibleDigital(false);
				setVisibleOptical(false);
	  			break;
	  		}
	  		case "3": {
	  			setVisibleStraight(false);
				setVisibleFreqcarry(false);
				//setVisibleDigital(false);
				setVisibleOptical(false);
	  			break;
	  		}
	  		case "4": {
	  			setVisibleStraight(false);
				setVisibleFreqcarry(false);
				setVisibleDigital(false);
				//setVisibleOptical(true);
	  			break;
	  		}
	  	}
	}
  
	function setVisibleStraight(visible) {
    	if (!visible) {
	    	document.all.repstraight.style.display = 'none';
	    	document.all.repstraight.style.visibility = 'hidden';
		} else {
	    	document.all.repstraight.style.display = 'block';
	    	document.all.repstraight.style.visibility = 'visible';
		}
  	}
  	
	function setVisibleDigital(visible) {
    	if (!visible) {
	    	document.all.repdigital.style.display = 'none';
	    	document.all.repdigital.style.visibility = 'hidden';
		} else {
	    	document.all.repdigital.style.display = 'block';
	    	document.all.repdigital.style.visibility = 'visible';
		}
	}
	
	function setVisibleFreqcarry(visible) {
    	if (!visible) {
	    	document.all.repfreqcarry1.style.display = 'none';
			document.all.repfreqcarry1.style.visibility = 'hidden';
			document.all.repfreqcarry2.style.display = 'none';
			document.all.repfreqcarry2.style.visibility = 'hidden';
		} else {
	    	document.all.repfreqcarry1.style.display = 'block';
			document.all.repfreqcarry1.style.visibility = 'visible';
	    	document.all.repfreqcarry2.style.display = 'block';
			document.all.repfreqcarry2.style.visibility = 'visible';
		}
	}
  
	function setVisibleOptical(visible) {
    	if (!visible) {
	    	document.all.repoptical.style.display = 'none';
	    	document.all.repoptical.style.visibility = 'hidden';
		} else {
	    	document.all.repoptical.style.display = 'block';
	    	document.all.repoptical.style.visibility = 'visible';
		}
	}
</SCRIPT>