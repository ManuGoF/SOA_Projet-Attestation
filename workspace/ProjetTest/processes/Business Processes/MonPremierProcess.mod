[Ivy]
[>Created: Mon Mar 30 14:10:43 CEST 2015]
14C6987B23D8C1FE 3.17 #module
>Proto >Proto Collection #zClass
Ms0 MonPremierProcess Big #zClass
Ms0 B #cInfo
Ms0 #process
Ms0 @TextInP .resExport .resExport #zField
Ms0 @TextInP .type .type #zField
Ms0 @TextInP .processKind .processKind #zField
Ms0 @AnnotationInP-0n ai ai #zField
Ms0 @MessageFlowInP-0n messageIn messageIn #zField
Ms0 @MessageFlowOutP-0n messageOut messageOut #zField
Ms0 @TextInP .xml .xml #zField
Ms0 @TextInP .responsibility .responsibility #zField
Ms0 @StartRequest f0 '' #zField
Ms0 @EndTask f1 '' #zField
Ms0 @GridStep f3 '' #zField
Ms0 @PushWFArc f4 '' #zField
Ms0 @TaskSwitchSimple f5 '' #zField
Ms0 @PushWFArc f2 '' #zField
Ms0 @Alternative f7 '' #zField
Ms0 @PushWFArc f8 '' #zField
Ms0 @TkArc f6 '' #zField
Ms0 @GridStep f9 '' #zField
Ms0 @EndTask f10 '' #zField
Ms0 @PushWFArc f11 '' #zField
Ms0 @PushWFArc f12 '' #zField
Ms0 @StartRequest f13 '' #zField
Ms0 @EndTask f14 '' #zField
Ms0 @Split f15 '' #zField
Ms0 @GridStep f16 '' #zField
Ms0 @GridStep f17 '' #zField
Ms0 @Join f18 '' #zField
Ms0 @PushWFArc f19 '' #zField
Ms0 @PushWFArc f20 '' #zField
Ms0 @PushWFArc f21 '' #zField
Ms0 @SJArc f22 '' #zField
Ms0 @SJArc f23 '' #zField
Ms0 @PushWFArc f24 '' #zField
Ms0 @WSElement f27 '' #zField
Ms0 @EMail f26 '' #zField
Ms0 @PushWFArc f29 '' #zField
Ms0 @EndTask f30 '' #zField
Ms0 @PushWFArc f31 '' #zField
Ms0 @GridStep f32 '' #zField
Ms0 @PushWFArc f25 '' #zField
Ms0 @StartRequest f28 '' #zField
Ms0 @PushWFArc f33 '' #zField
Ms0 @EndTask f35 '' #zField
Ms0 @RichDialog f36 '' #zField
Ms0 @PushWFArc f38 '' #zField
Ms0 @GridStep f39 '' #zField
Ms0 @StartRequest f34 '' #zField
Ms0 @PushWFArc f37 '' #zField
Ms0 @PushWFArc f40 '' #zField
>Proto Ms0 Ms0 MonPremierProcess #zField
Ms0 f0 outLink start.ivp #txt
Ms0 f0 type projetTest.Data #txt
Ms0 f0 inParamDecl '<> param;' #txt
Ms0 f0 actionDecl 'projetTest.Data out;
' #txt
Ms0 f0 guid 14C6987B2E32A4AE #txt
Ms0 f0 requestEnabled true #txt
Ms0 f0 triggerEnabled false #txt
Ms0 f0 callSignature start() #txt
Ms0 f0 persist false #txt
Ms0 f0 taskData '#
#Mon Mar 30 09:43:16 CEST 2015
TaskTriggered.ROL=Everybody
TaskTriggered.EXTYPE=0
TaskTriggered.EXPRI=2
TaskTriggered.TYPE=0
TaskTriggered.PRI=2
TaskTriggered.EXROL=Everybody
' #txt
Ms0 f0 caseData '#
#Mon Mar 30 09:43:17 CEST 2015
businessCalendarName=
businessCreator.user=
businessMilestone.timestamp=
businessObject.code=
businessObject.docDb.code=
businessObject.folder.id=
businessObject.name=
businessPriority=
businessStart.timestamp=
case.description=
case.name=
correspondent.id=
mainContact.docDb.code=
mainContact.folder.id=
mainContact.id=
mainContact.name=
mainContact.type=
process.code=
process.name=
processCategory.code=
processCategory.name=
subType.code=
subType.name=
type.code=
type.name=
' #txt
Ms0 f0 showInStartList 1 #txt
Ms0 f0 taskAndCaseSetupAction 'import ch.ivyteam.ivy.workflow.TaskUpdateDefinition;
ch.ivyteam.ivy.workflow.TaskUpdateDefinition taskUpdDef = new ch.ivyteam.ivy.workflow.TaskUpdateDefinition();
import ch.ivyteam.ivy.request.impl.DefaultCalendarProxy;
DefaultCalendarProxy calendarProxy = ivy.cal as DefaultCalendarProxy;
taskUpdDef.setPriority(ch.ivyteam.ivy.workflow.WorkflowPriority.valueOf(2));
taskUpdDef.setExpiryActivator("Everybody");
taskUpdDef.setExpiryPriority(ch.ivyteam.ivy.workflow.WorkflowPriority.valueOf(2));
engine.updateCurrentTask(taskUpdDef);
' #txt
Ms0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start.ivp</name>
        <nameStyle>9,5,7
</nameStyle>
    </language>
</elementInfo>
' #txt
Ms0 f0 @C|.responsibility Garage #txt
Ms0 f0 81 49 30 30 -21 17 #rect
Ms0 f0 @|StartRequestIcon #fIcon
Ms0 f1 type projetTest.Data #txt
Ms0 f1 529 49 30 30 0 15 #rect
Ms0 f1 @|EndIcon #fIcon
Ms0 f3 actionDecl 'projetTest.Data out;
' #txt
Ms0 f3 actionTable 'out=in;
' #txt
Ms0 f3 actionCode 'in.prenom = "Ced";' #txt
Ms0 f3 type projetTest.Data #txt
Ms0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>InitialisationPrenom</name>
        <nameStyle>20
</nameStyle>
    </language>
</elementInfo>
' #txt
Ms0 f3 160 42 128 44 -55 -8 #rect
Ms0 f3 @|StepIcon #fIcon
Ms0 f4 expr out #txt
Ms0 f4 111 64 160 64 #arcP
Ms0 f5 actionDecl 'projetTest.Data out;
' #txt
Ms0 f5 actionTable 'out=in1;
' #txt
Ms0 f5 outTypes "projetTest.Data" #txt
Ms0 f5 outLinks "TaskA.ivp" #txt
Ms0 f5 caseData '#
#Mon Mar 30 09:49:04 CEST 2015
businessCalendarName=
businessCreator.user=
businessMilestone.timestamp=
businessObject.code=
businessObject.docDb.code=
businessObject.folder.id=
businessObject.name=
businessPriority=
businessStart.timestamp=
case.description=
case.name=
correspondent.id=
mainContact.docDb.code=
mainContact.folder.id=
mainContact.id=
mainContact.name=
mainContact.type=
process.code=
process.name=
processCategory.code=
processCategory.name=
subType.code=
subType.name=
type.code=
type.name=
' #txt
Ms0 f5 taskData '#
#Mon Mar 30 09:49:04 CEST 2015
TaskA.EXPRI=2
TaskA.EXTYPE=-1
TaskA.PRI=2
TaskA.ROL=Garage
TaskA.SKIP_TASK_LIST=false
TaskA.TYPE=0
' #txt
Ms0 f5 taskAction 'import ch.ivyteam.ivy.workflow.TaskDefinition;
List<TaskDefinition> taskDefinitions;
TaskDefinition taskDef;import ch.ivyteam.ivy.request.impl.DefaultCalendarProxy;
DefaultCalendarProxy calendarProxy = ivy.cal as DefaultCalendarProxy;
taskDef = new TaskDefinition();
taskDef.setStartRequestPath("TaskA.ivp");
taskDef.setAutoStartTask(false);
taskDef.setActivator("Garage");
taskDef.setPriority(ch.ivyteam.ivy.workflow.WorkflowPriority.valueOf(2));
taskDef.setExpiryActivator(null);
taskDef.setExpiryPriority(ch.ivyteam.ivy.workflow.WorkflowPriority.valueOf(2));
taskDefinitions.add(taskDef);
' #txt
Ms0 f5 type projetTest.Data #txt
Ms0 f5 template "" #txt
Ms0 f5 433 49 30 30 0 16 #rect
Ms0 f5 @|TaskSwitchSimpleIcon #fIcon
Ms0 f2 expr data #txt
Ms0 f2 outCond ivp=="TaskA.ivp" #txt
Ms0 f2 463 64 529 64 #arcP
Ms0 f7 type projetTest.Data #txt
Ms0 f7 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Condition</name>
        <nameStyle>9
</nameStyle>
    </language>
</elementInfo>
' #txt
Ms0 f7 336 48 32 32 -26 18 #rect
Ms0 f7 @|AlternativeIcon #fIcon
Ms0 f8 expr out #txt
Ms0 f8 288 64 336 64 #arcP
Ms0 f6 expr in #txt
Ms0 f6 outCond in.prenom.equalsIgnoreCase("Cedric") #txt
Ms0 f6 type projetTest.Data #txt
Ms0 f6 var in1 #txt
Ms0 f6 368 64 433 64 #arcP
Ms0 f9 actionDecl 'projetTest.Data out;
' #txt
Ms0 f9 actionTable 'out=in;
' #txt
Ms0 f9 actionCode 'in.prix = 100;
in.raison = "reparation";' #txt
Ms0 f9 type projetTest.Data #txt
Ms0 f9 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>AffectationPrixRaison</name>
        <nameStyle>21
</nameStyle>
    </language>
</elementInfo>
' #txt
Ms0 f9 288 202 128 44 -58 -8 #rect
Ms0 f9 @|StepIcon #fIcon
Ms0 f10 type projetTest.Data #txt
Ms0 f10 337 337 30 30 0 15 #rect
Ms0 f10 @|EndIcon #fIcon
Ms0 f11 expr out #txt
Ms0 f11 352 246 352 337 #arcP
Ms0 f12 expr in #txt
Ms0 f12 352 80 352 202 #arcP
Ms0 f13 outLink start2.ivp #txt
Ms0 f13 type projetTest.Data #txt
Ms0 f13 inParamDecl '<> param;' #txt
Ms0 f13 actionDecl 'projetTest.Data out;
' #txt
Ms0 f13 guid 14C69B6A967F3E00 #txt
Ms0 f13 requestEnabled true #txt
Ms0 f13 triggerEnabled false #txt
Ms0 f13 callSignature start2() #txt
Ms0 f13 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start2.ivp</name>
    </language>
</elementInfo>
' #txt
Ms0 f13 @C|.responsibility Everybody #txt
Ms0 f13 753 33 30 30 -24 17 #rect
Ms0 f13 @|StartRequestIcon #fIcon
Ms0 f14 type projetTest.Data #txt
Ms0 f14 753 401 30 30 0 15 #rect
Ms0 f14 @|EndIcon #fIcon
Ms0 f15 actionDecl 'projetTest.Data out1;
projetTest.Data out2;
' #txt
Ms0 f15 actionTable 'out1=in;
' #txt
Ms0 f15 type projetTest.Data #txt
Ms0 f15 752 128 32 32 0 16 #rect
Ms0 f15 @|ThreadIcon #fIcon
Ms0 f16 actionDecl 'projetTest.Data out;
' #txt
Ms0 f16 actionTable 'out=in;
' #txt
Ms0 f16 actionCode 'in.prix = 100;' #txt
Ms0 f16 type projetTest.Data #txt
Ms0 f16 632 218 112 44 0 -8 #rect
Ms0 f16 @|StepIcon #fIcon
Ms0 f17 actionDecl 'projetTest.Data out;
' #txt
Ms0 f17 actionTable 'out=in;
' #txt
Ms0 f17 actionCode 'in.prenom = "John";
in.raison = "depannage";' #txt
Ms0 f17 type projetTest.Data #txt
Ms0 f17 840 234 112 44 0 -8 #rect
Ms0 f17 @|StepIcon #fIcon
Ms0 f18 actionDecl 'projetTest.Data out;
' #txt
Ms0 f18 actionTable 'out=in1;
out.prenom=in2.prenom;
out.prix=in1.prix;
out.raison=in2.raison;
' #txt
Ms0 f18 752 288 32 32 0 16 #rect
Ms0 f18 @|JoinIcon #fIcon
Ms0 f19 expr out #txt
Ms0 f19 768 63 768 128 #arcP
Ms0 f20 expr out1 #txt
Ms0 f20 761 153 688 218 #arcP
Ms0 f21 expr out2 #txt
Ms0 f21 777 151 896 234 #arcP
Ms0 f22 expr out #txt
Ms0 f22 type projetTest.Data #txt
Ms0 f22 var in1 #txt
Ms0 f22 688 262 759 297 #arcP
Ms0 f23 expr out #txt
Ms0 f23 type projetTest.Data #txt
Ms0 f23 var in2 #txt
Ms0 f23 840 277 780 300 #arcP
Ms0 f24 expr out #txt
Ms0 f24 768 320 768 401 #arcP
Ms0 f27 type projetTest.Data #txt
Ms0 f27 actionDecl 'projetTest.Data out;
' #txt
Ms0 f27 actionTable 'out=in;
' #txt
Ms0 f27 cache '{/cache false /invalidation false /scope 0 /groupname ""/lifetime_group "0"/invalidation_time_group ""/identifier ""/lifetime_entry "0"/invalidation_time_entry ""}' #txt
Ms0 f27 timeout 0 #txt
Ms0 f27 beanConfig '"KEY_PASSWORD=
KEY_AXIS_PORTNAME=BoatWSPort
KEY_WEBSERVICECONFIG_ID=14C69EDF14641525
KEY_DOMAIN=
KEY_USERNAME=
KEY_OPERATION=createBoat
KEY_AUTHENTICATION_KIND=0
KEY_HOST=
KEY_USE_AUTHENTICATION=false
KEY_AXIS_CSL_PARAMETER_DATA=""arg0.createBoat.boat__@@__ch.comem.ws.BoatTransport__@@__in.boatTransport"""' #txt
Ms0 f27 returningObjectList '[wsResponse]' #txt
Ms0 f27 1000 138 112 44 0 -8 #rect
Ms0 f27 @|WebServiceIcon #fIcon
Ms0 f26 beanConfig '"{/emailSubject ""Liste des bateauux""/emailFrom """"/emailReplyTo """"/emailTo ""cliengme@gmail.com""/emailCC """"/emailBCC """"/exceptionMissingEmailAttachments ""false""/emailMessage ""Bateau crée""/emailAttachments * }"' #txt
Ms0 f26 type projetTest.Data #txt
Ms0 f26 timeout 0 #txt
Ms0 f26 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Liste des bateaux</name>
        <nameStyle>17
</nameStyle>
    </language>
</elementInfo>
' #txt
Ms0 f26 1000 250 112 44 -48 -8 #rect
Ms0 f26 @|EMailIcon #fIcon
Ms0 f29 expr out #txt
Ms0 f29 1056 182 1056 250 #arcP
Ms0 f30 type projetTest.Data #txt
Ms0 f30 1041 417 30 30 0 15 #rect
Ms0 f30 @|EndIcon #fIcon
Ms0 f31 expr out #txt
Ms0 f31 1056 294 1056 417 #arcP
Ms0 f32 actionDecl 'projetTest.Data out;
' #txt
Ms0 f32 actionTable 'out=in;
' #txt
Ms0 f32 actionCode 'import ch.comem.ws.BoatTransport;
BoatTransport bt = new BoatTransport();
bt.setName("Navigator");
bt.setNumber("VD 1230");
in.boatTransport = bt;' #txt
Ms0 f32 type projetTest.Data #txt
Ms0 f32 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Bateau Transport</name>
        <nameStyle>16
</nameStyle>
    </language>
</elementInfo>
' #txt
Ms0 f32 1000 42 112 44 -47 -8 #rect
Ms0 f32 @|StepIcon #fIcon
Ms0 f25 expr out #txt
Ms0 f25 1056 86 1056 138 #arcP
Ms0 f28 outLink start3.ivp #txt
Ms0 f28 type projetTest.Data #txt
Ms0 f28 inParamDecl '<> param;' #txt
Ms0 f28 actionDecl 'projetTest.Data out;
' #txt
Ms0 f28 guid 14C6A005AF87FC83 #txt
Ms0 f28 requestEnabled true #txt
Ms0 f28 triggerEnabled false #txt
Ms0 f28 callSignature start3() #txt
Ms0 f28 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start3.ivp</name>
    </language>
</elementInfo>
' #txt
Ms0 f28 @C|.responsibility Everybody #txt
Ms0 f28 1041 1 30 30 -24 17 #rect
Ms0 f28 @|StartRequestIcon #fIcon
Ms0 f33 expr out #txt
Ms0 f33 1056 31 1056 42 #arcP
Ms0 f35 type projetTest.Data #txt
Ms0 f35 1361 313 30 30 0 15 #rect
Ms0 f35 @|EndIcon #fIcon
Ms0 f36 targetWindow NEW:card: #txt
Ms0 f36 targetDisplay TOP #txt
Ms0 f36 richDialogId projetTest.RIAtest #txt
Ms0 f36 startMethod startAvecObjet(ch.comem.ws.BoatTransport) #txt
Ms0 f36 type projetTest.Data #txt
Ms0 f36 requestActionDecl '<ch.comem.ws.BoatTransport boat> param;' #txt
Ms0 f36 requestMappingAction 'param.boat=in.boatTransport;
' #txt
Ms0 f36 responseActionDecl 'projetTest.Data out;
' #txt
Ms0 f36 responseMappingAction 'out=in;
' #txt
Ms0 f36 windowConfiguration '* ' #txt
Ms0 f36 isAsynch false #txt
Ms0 f36 isInnerRd false #txt
Ms0 f36 userContext '* ' #txt
Ms0 f36 1320 186 112 44 0 -8 #rect
Ms0 f36 @|RichDialogIcon #fIcon
Ms0 f38 expr out #txt
Ms0 f38 1376 230 1376 313 #arcP
Ms0 f39 actionDecl 'projetTest.Data out;
' #txt
Ms0 f39 actionTable 'out=in;
' #txt
Ms0 f39 actionCode 'import ch.comem.ws.BoatTransport;
BoatTransport bt = new BoatTransport();
bt.setName("Salut");
bt.setNumber("VD 8976");
in.boatTransport = bt;
' #txt
Ms0 f39 type projetTest.Data #txt
Ms0 f39 1320 74 112 44 0 -8 #rect
Ms0 f39 @|StepIcon #fIcon
Ms0 f34 outLink start4.ivp #txt
Ms0 f34 type projetTest.Data #txt
Ms0 f34 inParamDecl '<> param;' #txt
Ms0 f34 actionDecl 'projetTest.Data out;
' #txt
Ms0 f34 guid 14C6A8829E26353D #txt
Ms0 f34 requestEnabled true #txt
Ms0 f34 triggerEnabled false #txt
Ms0 f34 callSignature start4() #txt
Ms0 f34 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start4.ivp</name>
    </language>
</elementInfo>
' #txt
Ms0 f34 @C|.responsibility Everybody #txt
Ms0 f34 1361 17 30 30 -24 17 #rect
Ms0 f34 @|StartRequestIcon #fIcon
Ms0 f37 expr out #txt
Ms0 f37 1376 47 1376 74 #arcP
Ms0 f40 expr out #txt
Ms0 f40 1376 118 1376 186 #arcP
>Proto Ms0 .type projetTest.Data #txt
>Proto Ms0 .processKind NORMAL #txt
>Proto Ms0 0 0 32 24 18 0 #rect
>Proto Ms0 @|BIcon #fIcon
Ms0 f0 mainOut f4 tail #connect
Ms0 f4 head f3 mainIn #connect
Ms0 f5 out f2 tail #connect
Ms0 f2 head f1 mainIn #connect
Ms0 f3 mainOut f8 tail #connect
Ms0 f8 head f7 in #connect
Ms0 f7 out f6 tail #connect
Ms0 f6 head f5 in #connect
Ms0 f9 mainOut f11 tail #connect
Ms0 f11 head f10 mainIn #connect
Ms0 f7 out f12 tail #connect
Ms0 f12 head f9 mainIn #connect
Ms0 f13 mainOut f19 tail #connect
Ms0 f19 head f15 in #connect
Ms0 f15 out f20 tail #connect
Ms0 f20 head f16 mainIn #connect
Ms0 f15 out f21 tail #connect
Ms0 f21 head f17 mainIn #connect
Ms0 f16 mainOut f22 tail #connect
Ms0 f22 head f18 in #connect
Ms0 f17 mainOut f23 tail #connect
Ms0 f23 head f18 in #connect
Ms0 f18 mainOut f24 tail #connect
Ms0 f24 head f14 mainIn #connect
Ms0 f27 mainOut f29 tail #connect
Ms0 f29 head f26 mainIn #connect
Ms0 f26 mainOut f31 tail #connect
Ms0 f31 head f30 mainIn #connect
Ms0 f32 mainOut f25 tail #connect
Ms0 f25 head f27 mainIn #connect
Ms0 f28 mainOut f33 tail #connect
Ms0 f33 head f32 mainIn #connect
Ms0 f36 mainOut f38 tail #connect
Ms0 f38 head f35 mainIn #connect
Ms0 f34 mainOut f37 tail #connect
Ms0 f37 head f39 mainIn #connect
Ms0 f39 mainOut f40 tail #connect
Ms0 f40 head f36 mainIn #connect
