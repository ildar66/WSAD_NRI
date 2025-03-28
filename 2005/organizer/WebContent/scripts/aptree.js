/* $Revision: 1.3 $ $Date: 2006/09/04 14:55:36 $ $Author: IShaffigulin $ */
/***********************************************************************
* ADSTAR Distributed Storage Manager (adsm)                            *
* Server Component                                                     *
*                                                                      *
* IBM Confidential                                                     *
* (IBM Confidential-Restricted when combined with the Aggregated OCO   *
* Source Modules for this Program)                                     *
*                                                                      *
* OCO Source Materials                                                 *
*                                                                      *
* 5648-020 (C) Copyright IBM Corporation 1990, 1997 (Unpublished)      *
***********************************************************************/

/***********************************************************************
* Name:
*        JSTree.js
*
* Function:
*        Provide a Dynamic tree in a web browser.
*
* Author:
*        BJ Scheid
*        Roy Tritch
*
* Status:
*        Version 3, Release 2
*
* Environment:
*        This is a PLATFORM-INDEPENDENT source file. As such it may
*        contain no dependencies on any specific operating system
*        environment or hardware platform.
*
* Public Routines:
*
* Description:
*        ...
*
* Design Notes:
*        ...
*
* Change activity:
*
*  $Log: aptree.js,v $
*  Revision 1.3  2006/09/04 14:55:36  IShaffigulin
*  *** empty log message ***
*
*  Revision 1.2  2005/12/23 12:46:23  dima
*  *** empty log message ***
*
*  Revision 1.1.2.1  2005/12/14 09:28:42  ildar
*  *** empty log message ***
*
*  Revision 1.1  2004/11/25 15:11:00  ildar
*  ������ �������� ������ �������
*
*
***********************************************************************/




/////////////////////////////////////////////////////////////
// Global Variables
/////////////////////////////////////////////////////////////

var tree_root = null;        // node to the root of the tree
var maxNodes = 0;            // total count of the nodes
var browser = 2;             // browser type
var nodeIndex = null;        // index of all the nodes in the tree
var totalWidth = 0;          // total width of the tree
var abort = null;            // Abort Url if browser doesn't support dhtml
var selected = null;         // The currently selected item
var expandDepth = -1;        // Depth to which we should initially expand;
                             // expand the entire tree by default
var showselect = 0;          // = 1 if we are to change icon on select
var selectedicon = "/images/select.gif";
var selectednode = null;

/*** The following were added my M Etgen  ***/

var blankIcon = "/images/blank20.gif";
var openFolder = "/images/open_folder.gif";
var closedFolder = "/images/closed_folder.gif";
var plusIcon = "";
var minusIcon = "";
var targetFrame = "";
var inTable = "";
var keepState = "";
var showHealth = "";
var showExpanders = "";
var imagePath = "";

var helpPath = "";


/**  If the tree has a form element above, ns4 needs to adjust the tree up 30 px or so **/
var ns4InFormAdjustment = 10;

/**  Whether to let the text wrap or not - value should be <NOBR> and </NOBR> for wrap off **/
//var beginBreak = "<NOBR>";
var beginBreak = "";
//var endBreak = "</NOBR>";
var endBreak = "";

var isitblank = -1;




/////////////////////////////////////////////////////////////
// Define a tree node
//
// Inputs:
//   icon - name of the icon eg. /file/btn.gif
//   content - node or foler content (can be HTML text)
//   link - link for the name and icon
//   parent - parent node
//   id - id assigned to the node
/////////////////////////////////////////////////////////////
function TreeNode(icon, content, link, parent, id, level, is_selectable, itshealth)
{
   // Class Variables
   this.browser = 0;             // Browser Type
   this.icon = icon;             // Content Icon
   this.link = link;             // Content Link
   this.level = level;           // Nodes Level wrt root node
   this.content = content;       // Content to be displayed
   this.parent = parent;         // Parent TreeNode
   this.children = new Array;    // Children of the current TreeNode
   this.childCount = 0;          // Number of children of this TreeNode
   this.id = id;                 // TreeNode Id number
   this.layer = null;            // Layer refering to the content displayed
   this.width = 0;               // Width of the layer
   this.height = 0;              // Height of the layer
   this.expanded = false;        // Are the children visible
   this.visible = false;         // Is the node itself visiable
   this.PSrc = null;             // Plus icon source url
   this.MSrc = null;             // Minus icon source url
   this.button = null;           // Browser image object to the PM button
   this.img = null;              // Browser image object to the icon
   this.selectable = is_selectable; // Item is Selectable?
   
   this.health = itshealth;        //show health value?
   this.imagePath = imagePath;
   this.blankIcon = blankIcon;
   this.showExpanders = showExpanders;
   this.openFolder = openFolder;
   this.closedFolder = closedFolder;
   this.plusIcon = plusIcon;
   this.minusIcon = minusIcon;
   this.targetFrame = targetFrame;
   this.showHealth = showHealth;

   if (imagePath != "") {
        this.icon = imagePath + this.icon;
        this.blankIcon = imagePath + this.blankIcon;
        this.plusIcon =  imagePath + this.plusIcon;
        this.minusIcon =  imagePath + this.minusIcon;
        this.openFolder =  imagePath + this.openFolder;
        this.closedFolder =  imagePath + this.closedFolder;
   }
   
   var tempicon = icon;
   this.isitblank = isitblank;
   this.isitblank += tempicon.indexOf("onepix.gif",0);
   this.isitblank += tempicon.indexOf("blank20.gif",0);
   if (tempicon == "") { this.isitblank = 1; } 
   //alert("isitblank for "+this.id+" is "+this.isitblank);
   //this.isitblank += tempicon.indexOf("com.ibm.ws.console.security",0);
   //alert(document.location);
   var temploc = document.location.href;
   this.isitblank += temploc.indexOf("/navigator.jsp",0);

   // Class Methods
   this.displayTree = displayTree;
   this.layout = JSTree_Layout;
   this.displayStaticTree = displayStaticTree;

}
/////////////////////////////////////////////////////////////
// initalize()
//   Display the inital state of the tree.
//
// Inputs:
//   None.
// Output:
//   Tree is displayed in the browser.
// Notes:
//   The tree has already been built by the setTreeRoot and
//   addTreeNode methods.
/////////////////////////////////////////////////////////////
function initialize()
{

   var node = tree_root;

// quickly return to prevent error messages being displayed.
   if (node == null)
      return;

// setup the node index for faster access to tree members
   nodeIndex = new Array();
   createNodeIndex(node);

// if the complete topology view, keep state info
if (keepState) { 
        //alert(treeopen);  
        treeopen.length = nodeIndex.length;
}

// set the document node to the tree root
   document.node = tree_root;

// In Netscape create a layer that is big enough for all
// nodes to be displayed.  This is to force the scrollbars
// to appear since Netscape is not as dynamic as IE when it
// comes to scrollbars

/***modified - added browser 3***/

if (node.browser == 1 || node.browser == 3) {      
      var k;

      // Find the maximum width of the tree...

      for (k = 0; k < nodeIndex.length; k++) {
         var ndWidth = (nodeIndex[k].content.length * 7) + (22 * nodeIndex[k].level);
         if (ndWidth > totalWidth)
            totalWidth = ndWidth;
      }
      
      

     // The total height is the number node multiplied by the
     // number of icons plus some rubber chicken number.

      var totalHeight = (nodeIndex.length * 22) + 20;

// if the complete topology view
   if (!inTable) { 
      if (node.browser == 1) {
        document.write("<layer ID='Sizer'  visibility='visible' width='"+totalWidth+"' height='"+totalHeight+"' Z-INDEX='0'></LAYER>");
      }
      if (node.browser == 3) {
        document.write("<div ID='Sizer' style='visibility:VISIBLE' width='"+totalWidth+"'  Z-INDEX='0'></div>"); 
      }      
   }
            
   }




// display the tree
if (inTable && (node.browser == 1 || node.browser == 3)) {
        displayStaticTree(node, "", false, true, 1);
}
else {  
        displayTree(node, "", false, true, 1);

}

// flesh out the tree to its prior state
if ((keepState) && (!inTable)) {
        refreshCheck();
}


        // Expose the root unless depth was set to 0
           if ( expandDepth != null && expandDepth != 0 ) {
              node.visible = true;
           }   
        /*** modified - added browser 3  ***/
        
              if (node.browser == 1) {
                   if (!inTable) {
                        node.layer.visibility="show";
                   }
              }   
              else if (node.browser == 3) {
                   if (!inTable) {
                        document.getElementById("Item0").style.visibility="VISIBLE";
                   }
              }            
              else {
                 document.all["Item0"].style.display="block";
              }
              
              node.expanded = true;
        
              // Show's Roots Children
      
              if (node.browser == 1 || node.browser == 3) {   
                        if (!inTable) {
                                expandChildren(node, expandDepth);
                }
              }
              
              else {
                   expandChildren(node, expandDepth);
              }
        
           // layout all the created layer in Netscape           
           if (node.browser == 1 || node.browser == 3) {
                if (!inTable) {
                        node.layout();
                }
           }
           
           expandDepth = null;
        
        // Added to hide the --Please Wait...-- text inserted into Sizer for NS
            if (!inTable) {
                   if (node.browser == 1) {
                        document.Sizer.visibility="hide";
                   }
                   if (node.browser == 3) {
                        document.getElementById("Sizer").style.visibility="HIDDEN";
                   }
            }
        
        // Increment the counter for the number of tree refresh instances
           if (keepState) { 
                treecounter = top.treecounter + 1;
           }
 
}

/////////////////////////////////////////////////////////////
// createNodeIndex()
//   Create an index of all the nodes in the tree to speedup
//   lookup work.
//
// Inputs:
//   The root of the tree.
// Output:
//   The nodeIndex is created.
/////////////////////////////////////////////////////////////
function createNodeIndex(node)
{

   nodeIndex[node.id] = node;
   
   if (keepState) {     
        //if (node.id == 1) {   
        //        if (nodeIndex[1].content != treecontent[1]) {
        //                treecounter = 0; 
        //        }
        //}


   /*----- First time through, register the content with the id -----*/
   
        
        if (treecounter == 0) {
                treeopen[node.id] = 1;
        }
   }

        
  /*----------------------------------------------------------------*/


   var i;
   for (i = 0; i < node.childCount; i++) {
      createNodeIndex(node.children[i]);
   }
}


/////////////////////////////////////////////////////////////
// displayTree()
//   display the tree built in memory
//
// Inputs:
//   node - the node to show
//   spacer - html text spacer
//   lastNode - boolean flag inidcating last child
//   root - is this node the root node.
// Outputs:
//   The tree is displayed to the browser's window
/////////////////////////////////////////////////////////////
function displayTree(node, spacer, lastnode, root, level)
{
// Build the item layer --- added quotes around 'none' to keep Opera happy

   if (node.browser == 1) {
      if (root) {
              document.write("&#13;<layer class='indent"+node.level+"' id='Item"+node.id+"' visibility=hide width="+totalWidth+" z-index=1 >"+beginBreak);
              //alert("node id is " + node.id + " and level is "+node.level+" and has kids");
      }       
      else {
              if (node.childCount > 0) {
                        document.write("&#13;<layer class='indent"+node.level+"kids' id='Item"+node.id+"' visibility=hide width="+totalWidth+" z-index=1 >"+beginBreak);
                       // alert("node id is " + node.id + " and level is "+node.level+" and has kids"); 

              }
              else {
                        document.write("&#13;<layer class='indent"+node.level+"' id='Item"+node.id+"' visibility=hide width="+totalWidth+" z-index=1 >"+beginBreak);
                       // alert("node id is " + node.id + " and level is "+node.level+" and no kids"); 
              }
      
      }
   }
   
/*** modified - added browser 3 ***/

   else if (browser == 3) {
           if (node.childCount > 0) {
                document.write("<div class='indent"+node.level+"kids' id=Item"+node.id+" style='visibility: HIDDEN; font-size:110%' >"+beginBreak); 
                
           } 
           else {
                document.write("<div class='indent"+node.level+"' id=Item"+node.id+" style='visibility: HIDDEN; font-size:110%' >"+beginBreak); 
           }                 
   }      
   else {
           if (node.childCount > 0) {
                document.write("<div class='indent"+node.level+"kids' id=Item"+node.id+"  style=\"display:'none'\" >"+beginBreak); 
                //if (root) { alert("indent"+node.level+"kids"); }

           } 
           else {
                document.write("<div class='indent"+node.level+"' id=Item"+node.id+"  style=\"display:'none'\"  >"+beginBreak); 
                //alert("indent"+node.level);

           }  
   }
   

   
   
// Set the node's layer
   if (node.browser == 1) {
      node.layer = document.layers["Item"+node.id];
   }
   
/*** modified - added browser 3 ***/

   else if (browser == 3) {
      node.layer = document.getElementById("Item"+node.id); 
   }      
   else {
      node.layer = document.all["Item"+node.id];
   }



/********************** BEGIN IF HAS CHILDREN **************/


   if (node.childCount >0) {
   
     /**********  begin if not Root ********/

      if (!root) {
      
         // Determine what or if plus-minus buttons are needed
         // add the appropriate  buttons
         
            if (node.showExpanders) {
               node.PSrc = node.plusIcon;
               node.MSrc = node.minusIcon;
            }
            else {
               node.PSrc = node.blankIcon;
               node.MSrc = node.blankIcon;
            }
            
            if ( expandDepth == null || expandDepth < 0 || level <= expandDepth )
               useSrc = node.MSrc;
            else
               useSrc = node.PSrc;

            document.write("<a onclick='expandCompressNode("+node.id+");return false' onkeypress='expandCompressNode("+node.id+");return false' href='javascript:expandCompressNode("+node.id+")'>");
            document.write("<img src='"+ useSrc +"' name='PM"+node.id+"' id='plusminus' align='texttop' border='0' alt=''>");
//            var tempicon = node.icon;
//            var isitblank = tempicon.indexOf("onepix.gif",0)+1;
//            isitblank += tempicon.indexOf("blank20.gif",0)+1;
            if (node.isitblank < 0) {
                document.write("<img src="+node.icon+" name='icon" + node.id + "'   align='texttop'  border='0'  >");
            }
            
                  
            document.write("</a> ");
            

         // Set the node button to the appropriate browser image object

         if (node.browser == 1) {
            node.button = node.layer.document.images['PM'+node.id];
         }
         else if (node.browser == 3) {
            node.button = document.getElementsByName('PM'+node.id);
         }               
         else {
            node.button = document.all['PM'+node.id];
         }
         
       }  
      
      
     /**********  end if not Root ********/



      // Write the content of the node out

      if (node.selectable) {
          document.write("<a target='"+node.targetFrame+"' href=\"" + ebs(node.link) + " \">");      
       //     document.write("<a href=\"javascript:setBread("+node.id+")\" onclick=\"setBread("+node.id+")\">");
      }
      else {
            if (!root) {
                document.write("<a id='plusminus' onclick='expandCompressNode("+node.id+");return false' onkeypress='expandCompressNode("+node.id+");return false' href='javascript:expandCompressNode("+node.id+")'>");
            }
      }

      
      

      if (root) {
         document.write(node.content);
      }
      else {
         document.write(node.content+"</a>");
      }
      

      
      // Close the item layer
      if (node.browser == 1) {
                document.write(endBreak+"</layer>");
      }
      else {
                document.write(endBreak+"</div>");
      }



                      // Set the node icon to the appropriate browser image object
                      if (node.browser == 1)  {
                         node.img = node.layer.document.images['icon'+node.id];
                      }
                      /******** modified - added browser 3 ********/
                      else if (node.browser == 3) {
                         node.img = document.getElementsByName('icon'+node.id);
                      }   
                      else {
                         node.img = document.all['icon'+node.id];
                      }


      // Loop around all the children and add them
      for (var i = 0; i < node.childCount; i++) {
         var lstnode = false;
         if (i == (node.childCount -1))
            lstnode = true;
         node.children[i].displayTree(node.children[i], spacer, lstnode, false, level+1);
      }
   } 
      
/********************** END IF HAS CHILDREN **************/
   

/********************** BEGIN IF HAS NO CHILDREN **************/

   else {
         
      //var tempicon = node.icon;
      //var isitblank = tempicon.indexOf("onepix.gif",0)+1;
      //isitblank += tempicon.indexOf("blank20.gif",0)+1;
      if (node.isitblank < 0) {
        document.write("<img src="+node.icon+" name='icon" + node.id + "'   align='texttop'  border='0'  > ");
      }

      if (node.selectable) {
      /******** modified - removed references to ShowSelect ********/
              document.write("<a target='"+node.targetFrame+"' href=\"" + ebs(node.link) + "\">");
      //          document.write("<a href=\"javascript:setBread("+node.id+")\" onclick=\"setBread("+node.id+")\">");            
      }
      
      document.write(node.content);

      if (node.selectable)  {
         document.write( "</a>" );
      }



      // Close the item layer

      if (node.browser == 1) {
                document.write(endBreak+"</layer>");

      }
      else {
                document.write(endBreak+"</div>");
      }

   } 
   


                      // Set the node icon to the appropriate browser image object
                      if (node.browser == 1)  {
                         node.img = node.layer.document.images['icon'+node.id];
                      }
                      /******** modified - added browser 3 ********/
                      else if (node.browser == 3) {
                         node.img = document.getElementsByName('icon'+node.id);
                      }   
                      else {
                         node.img = document.all['icon'+node.id];
                      }

   
/********************** END IF HAS NO CHILDREN **************/



   if (node.browser == 2 || node.browser == 4) {
       if (node.parent != tree_root) {
          document.all["Item"+node.id].style.display = "none";
       }

   }
   






}



/////////////////////////////////////////////////////////////
// addItem()
//   Add an item to the tree
// Inputs:
//   parent - parent node
//   icon - name of the icon eg. ./file/btn.gif
//   content - node or folder content (can be HTML text)
//   link - link for the name and icon
// Output:
//   The tree node that has been created.
/////////////////////////////////////////////////////////////
function addItem(parent, icon, content, link, health)
{
   var selectable = true;

   if (parent == null) {
      // assume that a null parent infers adding to the root node
      parent = tree_root;
   }


   if (link == "") {
      selectable = false;
   }

   if (helpPath != "") {
      link = helpPath + link;
   }
   
   var thehealth = health;

   var tempNode = new TreeNode(icon, content, link, parent, maxNodes++, parent.level + 1, selectable, thehealth);
   tempNode.browser = browser;

   parent.children[parent.childCount++] = tempNode;
   
   
   return tempNode;
}


/////////////////////////////////////////////////////////////
// browserDetection()
//   determine browser type
//
// Inputs:
//   none
//         
// Output:
//   set browser type
/////////////////////////////////////////////////////////////
function browserDetection()  {
   
   // Determine the browser type
   // Browser Types:
   // 0 - Not supported
   // 1 - Netscape Communicator 4.x
   // 2 - IE
   // 3 - Opera
   // 4 - NS6


var thebrowser;

var foropera = window.navigator.userAgent.toLowerCase();
//alert(foropera);

var itsopera = foropera.indexOf("opera",0) + 1;
var itsgecko = foropera.indexOf("gecko",0) + 1;
var itsmozillacompat = foropera.indexOf("mozilla",0) + 1;
var itsmsie = foropera.indexOf("msie",0) + 1;



        if (itsopera > 0){
                /*******  Identify Opera as IE for static tree to show up *****/
                //thebrowser = 2
                thebrowser = 3;
                //alert("its opera");
                //isNav4 = true
                document.all = document.getElementsByTagName("*")

        }


        if (itsmozillacompat > 0){ 
                //alert("its mozilla compatible");
                if (itsgecko > 0) {
                        thebrowser = 4
                       // alert("its gecko");
                       //isNav4 = true
                       document.all = document.getElementsByTagName("*")

 
                }
                else if (itsmsie > 0) {
                      //  alert("its msie");
                        thebrowser = 2
                        //isIE = true
                }
                else {
                      //  alert("its ns4.x")
                        thebrowser = 1
                       // isNav4 = true
                }
        } 


return thebrowser;

}


/////////////////////////////////////////////////////////////
// addRoot()
//   Set the root of the tree to be constructed
// Inputs:
//   parent - parent node
//   icon - name of the icon eg. ./file/btn.gif
//   content - node or foler content (can be HTML text)
//   link - link for the name and icon
// Output:
//   The root tree node that has been created.
/////////////////////////////////////////////////////////////
function addRoot(icon, content, link)
{
   /******** modified - changed selectable to be determined *********/
   var selectable = true;

   if (link == "") {
      selectable = false;
   }

   /******** modified - removed browser detection from here *********/
   browser = browserDetection();

   // create a new node and set that as the root
   
   var tempNode = new TreeNode(icon, content, link, null, maxNodes++, 1, selectable);
   tempNode.browser = browser;

   tree_root = tempNode;
   return tempNode;
}

/////////////////////////////////////////////////////////////
// setAbort()
//   Set the url to abort to if browser dosen't support dhtml
//
// Inputs:
//   url - url to abort to if browser does not support Dynamic
//         html.
// Output:
//   golbal abort command is set
/////////////////////////////////////////////////////////////
function setAbort(url)
{
   abort = url;
}

function setImagePath(ip)
{
   imagePath = ip;
}

function setHelpPath (ip)
{
   helpPath = ip;
}

function setExpandDepth(iDepth)
{
   if ( iDepth != null && iDepth >= 0 )
      expandDepth = iDepth;
}

function setShowExpanders(sExpand)
{
   showExpanders = sExpand;
  
}


function setKeepState(ks)
{
   keepState = ks;
}


function setShowHealth(sh)
{
   showHealth = sh;
}


function setInTable(it)
{
   inTable = it;
}

function setTargetFrame(tf)
{
   targetFrame = tf;
}





/////////////////////////////////////////////////////////////
// expandChildren()
//   Expand the chlidren of the node by making the chlidren
//   nodes visable.
//
// Inputs:
//   node - the node to be expanded
//   depth - the absolute depth to which to expand (optional)
//           null:  expand leaves if previously expanded
//           < 0 :  forcefully expand entire tree
//           > 0 :  forcefully expand tree n levels from root
// Output:
//   None.
/////////////////////////////////////////////////////////////
function expandChildren(node,depth)
{
   var i;
   if ( depth )
      depth--;

   node.expanded = true;
   
   if (keepState) {
      if (treeopen)
        treeopen[node.id] = 0
   }
   
   
           for (i = 0; i < node.childCount; i++)
           {
              
              var cnode = node.children[i];
        
              // show the layers of this node 
              
              if (cnode.browser == 1) {
                    
                 document.layers['Item'+cnode.id].visibility="show";
                
              }
              
              /******** modified - added browser 3  *********/      
              else if (cnode.browser == 3) {
                 document.getElementById("Item"+cnode.id).style.visibility = "VISIBLE"; 
                 
              }      
              else  {
                 document.all["Item"+cnode.id].style.display = "block";
                 
              }
              cnode.visible = true;
        
              // open up any previouly open children
        
              if ( depth == null && cnode.expanded )
                 expandChildren(cnode);
              else
              {
                 if (depth != null && depth != 0 )
                    expandChildren(cnode,depth);
              }
        
           }
     

}
/////////////////////////////////////////////////////////////
// expandCompressNode()
//   Event Handler for the Plus-Minus buttons.  This procedure
//   will either expand a node or compress a node depending on
//   the current state of node.
//
// Inputs:
//   id - the id number of the node of which created the event
// Output:
//   None.
/////////////////////////////////////////////////////////////
function expandCompressNode(id)
{
   var node = nodeIndex[id];
   
   // determine the current state of the node
   
   var theimage = node.icon;
   var theimage2 = theimage.split("/");
   var theimage3 = theimage2[theimage2.length-1];
   var itsopen = node.openFolder.indexOf(theimage3,0) + 1;
   var itsclosed = node.closedFolder.indexOf(theimage3,0) + 1;
   //alert(itsopen+" Comparing "+node.openFolder+" to "+theimage3);
   
   if (!node.expanded)
   {
      node.button.src = node.MSrc;
      
      if (node.isitblank < 0) {
              if (itsclosed > 0) {
                node.img.src = node.openFolder;
                //alert("changing");
              }
              else {
                node.img.src = node.icon;
              }
      }
      
      node.expanded = true;

      expandChildren(node);
   }
   
   else
   {
      
      node.button.src = node.PSrc;
      
      if (node.isitblank < 0) {        
              if (itsopen > 0) {
                  node.img.src = node.closedFolder;
                  
              }
              else {
                  node.img.src = node.icon;
              }
      }

      node.expanded = false;

      compressChildren(node);
   }

/******** modified - added browser 3 ********/
if (!inTable) {
   if (node.browser == 1 || node.browser == 3)
      node.layout();
}

}

/////////////////////////////////////////////////////////////
// compressChildren()
//   Compress the chlidren of the node by hiding its chlidren
//   nodes.
//
// Inputs:
//   node - the node to be compressed
// Output:
//   None.
/////////////////////////////////////////////////////////////
function compressChildren(node)
{
   var i;
   if (keepState) {
      if (treeopen)
         treeopen[node.id] = 1
   
   }

   for (i = 0; i < node.childCount; i++)
   {
      var cnode = node.children[i];

      // Handle the different browser cases
      if (cnode.browser == 1) {
         document.layers['Item'+cnode.id].visibility="hide";
      }
      
      /******** modified - added browser 3 ********/
      
      else if (cnode.browser == 3) {
         document.getElementById("Item"+cnode.id).style.visibility = "HIDDEN";
          
      }      
      else  {
         document.all["Item"+cnode.id].style.display = "none";
         
      }
      
      cnode.visible = false;

      if (cnode.childCount > 0)
         compressChildren(cnode);
   }
}

/////////////////////////////////////////////////////////////
// JSTree_Layout()
//   Layout the layers of the tree one after another.
//
// Inputs:
//   None.  Uses document.layers to do the layout.
// Output:
//   A Laid out tree.
// Note:
//   This function is only needed for Netscape.
/////////////////////////////////////////////////////////////
function JSTree_Layout()
{
   var docLayers;
   
   /*******  BEGIN NS4.x Branch of Layout *********/
   
   if (browser == 1) {

        // extract the layers of the document
        docLayers = document.layers;

        // initalize position and loop variables
        var i = 0;
        var posY = docLayers[i].pageY + docLayers[i].document.height - ns4InFormAdjustment;

        for (i = 1; i < docLayers.length; i++)
        {
        // don't layout a hidden layer
                if (docLayers[i].visibility != "hide") {
         // set the location of the layer
                        docLayers[i].moveTo(docLayers[i].x, posY);
                        posY += docLayers[i].document.height;
                }
        }
    }
  /*******  END NS4.x Branch of Layout *********/
     
  /*******  BEGIN Opera Branch of Layout *********/

   else {      
        docLayers = document.getElementsByTagName("DIV");
        
        var i = 0;
        var posY = docLayers[i].offsetTop + docLayers[i].style.pixelHeight + 10;
        for (i = 1; i < docLayers.length; i++)    {
        
                // don't layout a hidden layer
                if (docLayers[i].style.visibility != "HIDDEN")   {
                
                        // set the location of the layer
                        docLayers[i].style.top = posY;
                        posY += docLayers[i].style.pixelHeight;
                }
        }
   }
  /*******  END Opera Branch of Layout *********/

}



/**********************************************************************
*  Helper and Utility functions *
***********************************************************************/

function Sel(id)
{
   var node = nodeIndex[id];
/*
   if (selected != null)
      selected.img.src = selected.icon;
*/
   selected = node;
   //selected.img.src = selectedicon;

   var node_ptr = selected.parent;
   var need_refresh = false;

   while (node_ptr && node_ptr != tree_root)
   {
      if (!node_ptr.expanded)
      {
         node_ptr.button.src = node_ptr.MSrc;
//alert(node_ptr.id);	
         //expandChildren(node_ptr);
expandCompressNode(node_ptr.id);
         node_ptr = node_ptr.parent;
         need_refresh = true;
      }
      else
         break;
   }

   //if (need_refresh && node.browser == 1)
      //node.layout();
}

// browsers parse (and unescape) the href in the processing
// of an onclick.  By the time str gets to our callback,
// it is escaped again.  This ensures our callback gets a
// string with escaped backslashes.

function ebs(str)
{
   if (!str || str == null)
      return("");

   return(str.replace(/\\/g, "\\\\"));
}


function clk(targetFrame, sPath)
{
  targetFrame.location= sPath;
}


function refreshCheck(){
   
  // alert(treeopen);

   for (j=0; j < treeopen.length; j++) {

      if (treeopen[j] == 0) {
              
        
        var thisnode = nodeIndex[j];
        
   //     alert("Open: "+thisnode.id);
        
        if (thisnode.button) {
                thisnode.button.src = thisnode.MSrc;
        }

        if (thisnode.isitblank < 0) {
        
                var theimage = thisnode.icon;
                var theimage2 = theimage.split("/");
                var theimage3 = theimage2[theimage2.length-1];
                var itsopen = thisnode.openFolder.indexOf(theimage3,0) + 1;
                var itsclosed = thisnode.closedFolder.indexOf(theimage3,0) + 1;
                
                if (itsclosed > 0) {
                        thisnode.img.src = thisnode.openFolder;
                }
                //else {
                //        thisnode.img.src = thisnode.icon;
                //}

         }

                 

         thisnode.expanded = true;

         expandChildren(thisnode);
      }

    }

}






/*******************************************  BEGIN DISPLAY STATIC TREE  **************************/

/////////////////////////////////////////////////////////////
// displayStaticTree()
//   display the tree built in memory
//
// Inputs:
//   node - the node to show
//   spacer - html text spacer
//   lastNode - boolean flag inidcating last child
//   root - is this node the root node.
// Outputs:
//   The tree is displayed to the browser's window
/////////////////////////////////////////////////////////////
function displayStaticTree(node, spacer, lastnode, root, level)

{

// Build the item layer --- added quotes around 'none' to keep Opera happy

      if (root) {
      
              document.write("<div class='indent"+node.level+"'>"+beginBreak);
              

      }       
      else {
                document.write("<div class='indent"+node.level+"'>"+beginBreak);
                
      }
   

   
   
        
   

/********************** BEGIN IF HAS CHILDREN **************/


   if (node.childCount > 0) {
   
     /**********  begin if not Root ********/


        document.write("<img src="+node.icon+" name='icon" + node.id + "'   align='texttop'  border='0'  > ");
      // Write the content of the node out

      if (node.selectable) {
          document.write("<a target='"+node.targetFrame+"' href=\"" + ebs(node.link) + " \">");      
      }
      

        
        if (root) {
                document.write(node.content);
        }
        else {
                document.write(node.content+"</a>");
        }
      

      
        document.write(endBreak+"</div>");




      // Loop around all the children and add them
      for (var i = 0; i < node.childCount; i++) {
         var lstnode = false;
         if (i == (node.childCount -1))
            lstnode = true;
         node.children[i].displayStaticTree(node.children[i], spacer, lstnode, false, level+1);
      }
   } 
   

      
/********************** END IF HAS CHILDREN **************/
   

/********************** BEGIN IF HAS NO CHILDREN **************/

   else {
         

      document.write("<img src="+node.icon+" name='icon" + node.id + "'   align='texttop'  border='0'  > ");
      if (node.selectable) {
        document.write("<a target='"+node.targetFrame+"' href=\"" + ebs(node.link) + "\">");
      }

      document.write(node.content);

      if (node.selectable)  {
         document.write( "</a>" );
      }


      document.write(endBreak+"</div>");


   } 
      



}





