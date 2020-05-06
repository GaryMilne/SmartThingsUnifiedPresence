/**
 *  Copyright 2019 - Gary J Milne
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */

// This is an Iconless version of the original.
 

preferences {
	section("Configure the Web Server"){
    	//I would like all of these to be required fields however I get an error on my android phone "Please fill out all required fields" when any of these are set to true, even when they are populated.
		input("destIp", "text", title: "IP", description: "The device IP", defaultValue: "192.168.0.X", required:false, displayDuringSetup: true )
    	input("destPort", "number", title: "Port", description: "The port you wish to connect.", defaultValue: "8001", required:false, displayDuringSetup: true )
        input("person", "text", title: "Person", description: "An owner'\'person from the unifiedpresence.json file.", defaultValue: "Bob", required:false, displayDuringSetup: true )
        input("frequency", "number", title: "Auto refresh in X minutes", description: "Enter 1, 5 or 10 minutes. (Default is 5)", defaultValue: "5", required:false, displayDuringSetup: false )
        input("fancynames", "boolean", title: "Enable fancy names?", defaultValue: false, required:false, displayDuringSetup: false)
    	}
    }
 
metadata {
	definition (name: "Unified Presence V1.0", namespace: "garyjmilne", author: "garyjmilne@gmail.com") {
		capability "Presence Sensor"
        command "getstatus"
        command "updatedni"
      	}

	simulator {
		// TODO-: define status and reply messages here
	}

	tiles (scale:2) {
		    standardTile("presence", "device.presence", width: 4, height: 1, canChangeBackground: false) {
				state("present", action: "departed", labelIcon:"st.presence.tile.mobile-present", backgroundColor:"#53a7c0", nextState: "not present")
				state("not present", action: "arrived", labelIcon:"st.presence.tile.mobile-not-present", backgroundColor:"#ffffff", nextState: "present")
			}
    
    		// Tile group 0
            valueTile("label0", "device.label0", width: 4, height: 1, decoration: "flat") {
                state "default", label:'${currentValue}', action:"", backgroundColor: "#ffffff"
                state "unused", label:"Unused", action:"", backgroundColor: "#ffffff"
            }
        	standardTile("switch0", "device.switch0", width: 2, height: 2, canChangeIcon: True, canChangeBackground: false) {
            	state "home", label:  "Home", action:"", backgroundColor: "#79b821", icon:"st.Home.home5"
            	state "away", label: "Away", action:"", backgroundColor: "#ffffff", icon:"st.Transportation.transportation2"
       		}
            
            valueTile("labeldetails", "device.labeldetails", width: 4, height: 1, decoration: "flat") {
                state "default", label:'${currentValue}', action:"", backgroundColor: "#ffffff"
            }
    
    		// Tile group 1
            valueTile("label1", "device.label1", width: 4, height: 1, decoration: "flat") {
                state "default", label:'${currentValue}', action:"", backgroundColor: "#ffffff"
                state "unused", label:"Unused", action:"", backgroundColor: "#ffffff"
            }
			standardTile("switch1", "device.switch1", width: 2, height: 1, canChangeIcon: True, canChangeBackground: false) {
            	state "on", label:  "Home", action:"", backgroundColor: "#79b821", icon:"st.Home.home5"
            	state "off", label: "Away", action:"", backgroundColor: "#ffffff", icon:"st.Transportation.transportation2"
       		}
			
            // Tile group 2
            valueTile("label2", "device.label2", width: 4, height: 1, decoration: "flat") {
                state "default", label:'${currentValue}', action:"", backgroundColor: "#ffffff"
                state "unused", label:"Unused", action:"", backgroundColor: "#ffffff"
            }
            standardTile("switch2", "device.switch2", width: 2, height: 1, canChangeIcon: True, canChangeBackground: false) {
                state "on", label:  "Home", action:"", backgroundColor: "#79b821", icon:"st.Home.home5"
            	state "off", label: "Away", action:"", backgroundColor: "#ffffff", icon:"st.Transportation.transportation2"
            }
            
            // Tile group 3
            valueTile("label3", "device.label3", width: 4, height: 1, decoration: "flat") {
                state "default", label:'${currentValue}', action:"", backgroundColor: "#ffffff"
                state "unused", label:"Unused", action:"", backgroundColor: "#ffffff"
            }
            standardTile("switch3", "device.switch3", width: 2, height: 1, canChangeIcon: True, canChangeBackground: false) {
                state "on", label:  "Home", action:"", backgroundColor: "#79b821", icon:"st.Home.home5"
            	state "off", label: "Away", action:"", backgroundColor: "#ffffff", icon:"st.Transportation.transportation2"
                state "unused", label: "Unused", action:"", backgroundColor: "#ffffff", icon:"st.Seasonal Fall.seasonal-fall-005"
            }
            
            // Tile group 4
            valueTile("label4", "device.label4", width: 4, height: 1, decoration: "flat") {
                state "default", label:'${currentValue}', action:"", backgroundColor: "#ffffff"
                state "unused", label:"Unused", action:"", backgroundColor: "#ffffff"
            }
            standardTile("switch4", "device.switch4", width: 2, height: 1, canChangeIcon: True, canChangeBackground: false) {
                state "on", label:  "Home", action:"", backgroundColor: "#79b821", icon:"st.Home.home5"
            	state "off", label: "Away", action:"", backgroundColor: "#ffffff", icon:"st.Transportation.transportation2"
                state "unused", label: "Unused", action:"", backgroundColor: "#ffffff", icon:"st.Seasonal Fall.seasonal-fall-005"
            }
            
			standardTile("lastupdated", "device.lastupdated", width: 4, height: 2 ,inactiveLabel: true, decoration: "flat") {
				state "default", label:'${currentValue}', action:"", icon:""
       		}
            
           	standardTile("refresh", "device.switch", width: 2, height: 2 ,inactiveLabel: false, decoration: "flat") {
				state "default", label:'Refresh', action:"getstatus", icon:"st.secondary.refresh"
       		}
            
            standardTile("dni", "device.dni", width: 4, height: 1 ,inactiveLabel: false, decoration: "flat") {
				state "default", label:'${currentValue}', action:"updatedni", icon:""
       		}
            
            standardTile("poll", "device.poll", width: 2, height: 1 ,inactiveLabel: false, decoration: "flat") {
				state "default", label:'${currentValue}', action:"", icon:""
       		}
         }
        
        //The tile that represents this app in the device list in the Smartthings app.
        main(["switch0"])
        
        //This is the order in which they are displayed in the SmartThings Classic app.
        //Use this line if you have three devices
        //details(["label0","switch0","labeldetails","label1","switch1","label2","switch2","label3","switch3","lastupdated","refresh"])
        //Use this line if you have four devices
        details(["label0","switch0","labeldetails","label1","switch1","label2","switch2","label3","switch3","label4","switch4","lastupdated","refresh","dni","poll"])
	}
    

def initialize(){
	//Cancel any existing scheduled tasks
    unschedule()
	//Make sure we are using the right address
    updateDeviceNetworkID()
    //Sometime the first attempt to change the DNI does not work so we will schedule a second attempt 10 seconds from now.
    runIn(10,updateDeviceNetworkID)
	//Test to make sure the entered frequency is in range
    switch(settings.frequency) { 
        case 1: runEvery1Minute(getstatus) ; sendEvent(name: "poll", value: "1️", displayed:false) ;break;
        case 5: runEvery5Minutes(getstatus) ; sendEvent(name: "poll", value: "5️", displayed:false) ; break;
        case 10: runEvery10Minutes(getstatus) ; sendEvent(name: "poll", value: "10", displayed:false) ; break;
        default: runEvery10Minutes(getstatus) ; sendEvent(name: "poll", value: "5️", displayed:false) ;break;
    } 
    getstatus()
}

//This function runs after the user updates the available options
def updated() {
    initialize()
	}

// Makes a call to the webserver to obtain the latest copy of unifiedpresence.json
def getstatus() { 
	//log.debug "Starting Get json"
    def destIp = settings.destIp
    def destPort = settings.destPort
    //log.debug "Connecting to: ${destIp}:${destPort}"
    try{
        def hubAction = new physicalgraph.device.HubAction(
                'method': 'GET',
                'path': "/unifiedpresence.json",
                'headers': [ HOST: "$destIp:$destPort" ]) 
        //log.debug "hubaction is: " + hubAction
        //https://community.smartthings.com/t/hubaction-not-executed-when-scheduled-via-runin-from-device-handler/37429/15
        //I had just been using hubAction. This would work fine if called manually from the app but not from RunEveryXX. Using sendHubCommand(hubAction) fixed it.
        // This will call the Parse function
        sendHubCommand(hubAction)
    }
    catch (e){ log.debug "Error encountered in Getjson(): ${e}" }
}

//parse is called after a successful return of data from the HTTP GET call to the webserver
def parse(description) {
    //log.debug "parse starting"
    def msg = parseLanMessage(description)
	def json = msg.json              // => any JSON included in response body, as a data structure of lists and map
    //log.debug "json is: ${json}"
    def OwnerList = []
    def DeviceList = []
    
    //log.debug "Start Loop"
  	//Split the json file into two seperate lists of owner and device records  
    def devicecount = 0
    def ownercount = 0
    for (rec in json) { 
        //log.debug "Rec Device: ${rec.Device}"
        if (rec.Device == "Combined"){ 
        	OwnerList.add(rec)
        }
        else {
        	DeviceList.add(rec)
        }
    }
    //log.debug "End Loop"
    //log.debug "OwnerList: ${OwnerList}"
    //log.debug "DeviceList: ${DeviceList}"

    ParseOwnerjson(OwnerList)
   	ParseDevicejson(DeviceList)
	} 
    
//Processes the OwnerList and populates the owner status\presence
def ParseOwnerjson(OwnerList){
    //log.debug "OwnerList is: ${OwnerList}"
    def MyOwner = settings.person
    def NumberofOwners = OwnerList.size()
    def newline = "\n"
    def LastIn
    def LastOut
    
    //Write the name of the person in label0 - the top one.
    //Bizzarely boolean values are stored as true\false strings.
    if (settings.fancynames == "true") {
    	def picName = GetName ("${MyOwner}")
    	//log.debug "picName: ${picName}"
        //sendEvent(name: "label0", value: "${picName}${newline}(As of: 10:19 PM)")
        sendEvent(name: "label0", value: "${picName}", displayed:false)
        }
    else {
    log.debug "Fancy is false"
    	sendEvent(name: "label0", value: "${MyOwner} Unified Presence", displayed:false)
    	}
    
    try {
    	for (rec in OwnerList) {
        	if (rec.Owner == settings.person) {
            	sendEvent(name: "lastupdated", value: "Updated: ${rec.Last_Update}", displayed:false)
                LastIn = rec.Last_In
                LastOut = rec.Last_Out
                //sendEvent(name: "lastupdated", value: "My Value" )
                //def device.OwnerDetail = rec
            	//log.debug "Owner: ${rec.Owner} Status: ${rec.Status}"
        		if (rec.Status == "In") {
                    sendEvent(name: "presence", value: "present")
                    sendEvent(name: "switch0", value: "home", displayed:false)
                    sendEvent(name: "labeldetails", value: "In: ${rec.Last_In}", displayed:true)
                    log.debug "Unified Presence for ${settings.person} is: Home"
                	} 
            	else {
    	            sendEvent(name: "presence", value: "not present") 
                    sendEvent(name: "switch0", value: "away", displayed:false)
                    sendEvent(name: "labeldetails", value: "Out: ${rec.Last_Out}", displayed:true)
                    log.debug "Unified Presence for ${settings.person} is: Away"
                    }
        	    } 
        	} //end of for
        }
      catch (e){ log.debug "Error encountered in ParseOwnerjson(): ${e}" }
    //log.debug "Finished Owner json"
}

//Processes the DeviceList and populates the individual device details and status\presence
def ParseDevicejson(DeviceList){
    def OwnerDeviceCount = 0
    def Index = 0
    def MyOwner = settings.person
    def newline = "\n"
    def prefix
    def olddatetime 
    //log.debug "Owner is: ${MyOwner}"
    try {
    	for (rec in DeviceList) {
        	Index = Index + 1
        	//Clear the device label before we start
            sendEvent(name: "label${Index}", value: "", displayed:false)
        	//log.debug "Index is: ${Index}"
    		//log.debug json[x].Status
        	if (rec.Owner == MyOwner) {
            
            	if (rec.Status == "In"){
                	olddatetime = rec.Last_In
                    prefix = "In: "
                    }
                else {
                	olddatetime = rec.Last_Out
                    prefix = "Out: "
                }
                
                def oldpattern = "EEE MM/dd/yy '@' hh:mm a"
				def parseddatetime = Date.parse(oldpattern, olddatetime)
                def newpattern = "EEE '@' hh:mm a"
 				def newdatetime = parseddatetime.format( newpattern )
                OwnerDeviceCount = OwnerDeviceCount + 1
            	
                //Update the Device label.
                //sendEvent(name: "label${OwnerDeviceCount}", value: "${rec.Device} ${newline} ${prefix}${newdatetime}")
                sendEvent(name: "label${OwnerDeviceCount}", value: "${rec.Device} ${newline}${prefix}${newdatetime}", displayed:false)
                //log.debug "Field is: ${rec.Last_In}"
                if (rec.Status == "In"){ 
                	//log.debug "Switching on switch${OwnerDeviceCount}"
                    sendEvent(name: "switch${OwnerDeviceCount}", value: 'on', displayed:false)
                    }
                else{
                	//log.debug "Switching off switch${OwnerDeviceCount}"
                    sendEvent(name: "switch${OwnerDeviceCount}", value: 'off', displayed:false)
                	}
        		}
        	} //end of For
            
      //log.debug "Owner Device Count ${OwnerDeviceCount}"
      //log.debug "Number of Devices ${NumberofDevices}"
      def x = 0
      for (x = OwnerDeviceCount+1; x < 5; x++) {
      	//log.debug "X here is: ${x}"
       	//Wipe out the descriptions for unused devices if they are present
        sendEvent(name: "label${x}", value: 'unused', displayed:false)
        sendEvent(name: "switch${x}", value: 'unused', displayed:false)
       }
            
        } //end of try
      catch (e){ log.debug "Error encountered in ParseDevicejson(): ${e}" }   
}

// *************************
// Supporting functions
private String convertIPtoHex(ipAddress) { 
    String hex = ipAddress.tokenize( '.' ).collect {  String.format( '%02X', it.toInteger() ) }.join()
    return hex
}

private String convertPortToHex(port) {
	String hexport = port.toString().format( '%04X', port.toInteger() )
    return hexport
}

//Allows user to force an update of the device network information.
def updatedni(){
	log.debug "Running updatedni"
	updateDeviceNetworkID()
    }

//Updates the device network information.
def updateDeviceNetworkID() {
	def newline = "\n"
    def tab = "\t"
	log.debug "Updating Device Network ID"
    
    try{
        //log.debug "Settings.destIP is: ${settings.destIp}"
        def hosthex = convertIPtoHex(settings.destIp)
        def porthex = convertPortToHex(settings.destPort)
    	def desireddni = "$hosthex:$porthex"
        
        def actualdni = device.deviceNetworkId
        
        //If they don't match then we need to update the DNI
        if (desireddni !=  actualdni){
        	device.deviceNetworkId = "$hosthex:$porthex" 
        	//device.deviceNetworkId = "DCA6321B43B2" - Using the MAC address does not work.
        	log.debug "DNI updated to: ${"$hosthex:$porthex"}"
         	}
        }
    catch (e){ log.debug "Error updating Device Network ID: ${e}" }
    sendEvent(name: "dni", value: "DNI:${device.deviceNetworkId}${newline}", displayed:false)
}


//Converts an alpha character into a unicode graphical character
private String GetName(name){

	def String iconname = ""
    def String icon = ""
    
	for (chr in name) {
		//log.debug "Char is: ${chr}"
    	switch(chr.toLowerCase()) { 
   	    case ["a"]: icon = "A" ; break;
            case ["b"]: icon = "B" ; break;
            case ["c"]: icon = "C" ; break;
            case ["d"]: icon = "D" ; break;
            case ["e"]: icon = "E" ; break;
            case ["f"]: icon = "F" ; break;
            case ["g"]: icon = "G" ; break;
            case ["h"]: icon = "H" ; break;
            case ["i"]: icon = "I" ; break;
            case ["j"]: icon = "J" ; break;
            case ["k"]: icon = "K" ; break;
            case ["l"]: icon = "L" ; break;
            case ["m"]: icon = "M" ; break;
            case ["n"]: icon = "N" ; break;
            case ["o"]: icon = "O" ; break;
            case ["p"]: icon = "P" ; break;
            case ["q"]: icon = "Q" ; break;
            case ["r"]: icon = "R" ; break;
            case ["s"]: icon = "S" ; break;
            case ["t"]: icon = "T" ; break;
            case ["u"]: icon = "U" ; break;
            case ["v"]: icon = "V" ; break;
            case ["w"]: icon = "W" ; break;
            case ["x"]: icon = "X" ; break;
            case ["y"]: icon = "Y" ; break;
            case ["y"]: icon = "Z" ; break;
    	}
        //If we don't have a space between the characters it treats them like integers rathern than strings and we get some high order unicode symbol instead.
        iconname = iconname + " " + icon
	}
    return iconname
}