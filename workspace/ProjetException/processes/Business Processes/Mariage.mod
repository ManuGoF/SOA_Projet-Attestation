[Ivy]
[>Created: Mon Mar 30 15:52:54 CEST 2015]
14C6AEF4EA6880D0 3.17 #module
>Proto >Proto Collection #zClass
Me0 Mariage Big #zClass
Me0 B #cInfo
Me0 #process
Me0 @TextInP .resExport .resExport #zField
Me0 @TextInP .type .type #zField
Me0 @TextInP .processKind .processKind #zField
Me0 @AnnotationInP-0n ai ai #zField
Me0 @MessageFlowInP-0n messageIn messageIn #zField
Me0 @MessageFlowOutP-0n messageOut messageOut #zField
Me0 @TextInP .xml .xml #zField
Me0 @TextInP .responsibility .responsibility #zField
Me0 @StartRequest f0 '' #zField
Me0 @EndTask f1 '' #zField
Me0 @TaskSwitchSimple f3 '' #zField
Me0 @TkArc f4 '' #zField
Me0 @PushWFArc f2 '' #zField
Me0 @ProcessException f5 '' #zField
Me0 @EndTask f6 '' #zField
Me0 @TaskSwitchSimple f8 '' #zField
Me0 @TkArc f9 '' #zField
Me0 @PushWFArc f7 '' #zField
>Proto Me0 Me0 Mariage #zField
Me0 f0 outLink start.ivp #txt
Me0 f0 type projetException.Data #txt
Me0 f0 inParamDecl '<> param;' #txt
Me0 f0 actionDecl 'projetException.Data out;
' #txt
Me0 f0 guid 14C6AEF4EAE7CA23 #txt
Me0 f0 requestEnabled true #txt
Me0 f0 triggerEnabled false #txt
Me0 f0 callSignature start() #txt
Me0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start.ivp</name>
    </language>
</elementInfo>
' #txt
Me0 f0 @C|.responsibility Everybody #txt
Me0 f0 81 49 30 30 -21 17 #rect
Me0 f0 @|StartRequestIcon #fIcon
Me0 f1 type projetException.Data #txt
Me0 f1 337 49 30 30 0 15 #rect
Me0 f1 @|EndIcon #fIcon
Me0 f3 actionDecl 'projetException.Data out;
' #txt
Me0 f3 actionTable 'out=in1;
' #txt
Me0 f3 outTypes "projetException.Data" #txt
Me0 f3 outLinks "TaskA.ivp" #txt
Me0 f3 caseData '#
#Mon Mar 30 15:52:28 CEST 2015
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
Me0 f3 taskData '#
#Mon Mar 30 15:52:28 CEST 2015
TaskA.EXC=14C6AEF4EA6880D0-f5-buffer
TaskA.EXP=''1s''
TaskA.EXPRI=2
TaskA.EXROL=BeauxParent
TaskA.EXTYPE=0
TaskA.PRI=2
TaskA.ROL=Parent
TaskA.SKIP_TASK_LIST=false
TaskA.TYPE=0
' #txt
Me0 f3 taskAction 'import ch.ivyteam.ivy.workflow.TaskDefinition;
List<TaskDefinition> taskDefinitions;
TaskDefinition taskDef;import ch.ivyteam.ivy.request.impl.DefaultCalendarProxy;
DefaultCalendarProxy calendarProxy = ivy.cal as DefaultCalendarProxy;
taskDef = new TaskDefinition();
taskDef.setStartRequestPath("TaskA.ivp");
taskDef.setAutoStartTask(false);
taskDef.setActivator("Parent");
taskDef.setPriority(ch.ivyteam.ivy.workflow.WorkflowPriority.valueOf(2));
taskDef.setExpiryPeriod(1000 * (''1s'').toNumber());
taskDef.setExpiryActivator("BeauxParent");
taskDef.setExpiryPriority(ch.ivyteam.ivy.workflow.WorkflowPriority.valueOf(2));
taskDef.setExpiryStartTaskElementPid("14C6AEF4EA6880D0-f5-buffer");
taskDefinitions.add(taskDef);
' #txt
Me0 f3 type projetException.Data #txt
Me0 f3 template "" #txt
Me0 f3 177 49 30 30 0 16 #rect
Me0 f3 @|TaskSwitchSimpleIcon #fIcon
Me0 f4 expr out #txt
Me0 f4 type projetException.Data #txt
Me0 f4 var in1 #txt
Me0 f4 111 64 177 64 #arcP
Me0 f2 expr data #txt
Me0 f2 outCond ivp=="TaskA.ivp" #txt
Me0 f2 207 64 337 64 #arcP
Me0 f5 .resExport export #txt
Me0 f5 actionDecl 'projetException.Data out;
' #txt
Me0 f5 actionTable 'out=in;
' #txt
Me0 f5 type projetException.Data #txt
Me0 f5 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>ParentsIncompetents</name>
        <nameStyle>19
</nameStyle>
    </language>
</elementInfo>
' #txt
Me0 f5 145 225 30 30 -59 17 #rect
Me0 f5 @|ExceptionIcon #fIcon
Me0 f6 type projetException.Data #txt
Me0 f6 337 241 30 30 0 15 #rect
Me0 f6 @|EndIcon #fIcon
Me0 f8 actionDecl 'projetException.Data out;
' #txt
Me0 f8 actionTable 'out=in1;
' #txt
Me0 f8 outTypes "projetException.Data" #txt
Me0 f8 outLinks "TaskA.ivp" #txt
Me0 f8 caseData '#
#Mon Mar 30 15:52:49 CEST 2015
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
Me0 f8 taskData '#
#Mon Mar 30 15:52:49 CEST 2015
TaskA.EXPRI=2
TaskA.EXROL=Everybody
TaskA.EXTYPE=0
TaskA.PRI=2
TaskA.ROL=BeauxParent
TaskA.SKIP_TASK_LIST=false
TaskA.TYPE=0
' #txt
Me0 f8 taskAction 'import ch.ivyteam.ivy.workflow.TaskDefinition;
List<TaskDefinition> taskDefinitions;
TaskDefinition taskDef;import ch.ivyteam.ivy.request.impl.DefaultCalendarProxy;
DefaultCalendarProxy calendarProxy = ivy.cal as DefaultCalendarProxy;
taskDef = new TaskDefinition();
taskDef.setStartRequestPath("TaskA.ivp");
taskDef.setAutoStartTask(false);
taskDef.setActivator("BeauxParent");
taskDef.setPriority(ch.ivyteam.ivy.workflow.WorkflowPriority.valueOf(2));
taskDef.setExpiryActivator("Everybody");
taskDef.setExpiryPriority(ch.ivyteam.ivy.workflow.WorkflowPriority.valueOf(2));
taskDefinitions.add(taskDef);
' #txt
Me0 f8 type projetException.Data #txt
Me0 f8 template "" #txt
Me0 f8 241 233 30 30 0 16 #rect
Me0 f8 @|TaskSwitchSimpleIcon #fIcon
Me0 f9 expr out #txt
Me0 f9 type projetException.Data #txt
Me0 f9 var in1 #txt
Me0 f9 174 241 241 246 #arcP
Me0 f7 expr data #txt
Me0 f7 outCond ivp=="TaskA.ivp" #txt
Me0 f7 270 249 337 254 #arcP
>Proto Me0 .type projetException.Data #txt
>Proto Me0 .processKind NORMAL #txt
>Proto Me0 0 0 32 24 18 0 #rect
>Proto Me0 @|BIcon #fIcon
Me0 f0 mainOut f4 tail #connect
Me0 f4 head f3 in #connect
Me0 f3 out f2 tail #connect
Me0 f2 head f1 mainIn #connect
Me0 f5 mainOut f9 tail #connect
Me0 f9 head f8 in #connect
Me0 f8 out f7 tail #connect
Me0 f7 head f6 mainIn #connect
