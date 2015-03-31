[Ivy]
[>Created: Mon Mar 30 15:24:16 CEST 2015]
14C6A9C2B8FFBDCD 3.17 #module
>Proto >Proto Collection #zClass
PA0 PeuplementRIA Big #zClass
PA0 B #cInfo
PA0 #process
PA0 @TextInP .resExport .resExport #zField
PA0 @TextInP .type .type #zField
PA0 @TextInP .processKind .processKind #zField
PA0 @AnnotationInP-0n ai ai #zField
PA0 @MessageFlowInP-0n messageIn messageIn #zField
PA0 @MessageFlowOutP-0n messageOut messageOut #zField
PA0 @TextInP .xml .xml #zField
PA0 @TextInP .responsibility .responsibility #zField
PA0 @StartRequest f0 '' #zField
PA0 @RichDialog f5 '' #zField
PA0 @PushWFArc f2 '' #zField
PA0 @EndTask f1 '' #zField
PA0 @PushWFArc f3 '' #zField
PA0 @StartRequest f4 '' #zField
PA0 @RichDialog f6 '' #zField
PA0 @PushWFArc f7 '' #zField
PA0 @EndTask f8 '' #zField
PA0 @PushWFArc f9 '' #zField
>Proto PA0 PA0 PeuplementRIA #zField
PA0 f0 outLink start.ivp #txt
PA0 f0 type projetTest.Data #txt
PA0 f0 inParamDecl '<> param;' #txt
PA0 f0 actionDecl 'projetTest.Data out;
' #txt
PA0 f0 guid 14C6A9C2B9D44A3A #txt
PA0 f0 requestEnabled true #txt
PA0 f0 triggerEnabled false #txt
PA0 f0 callSignature start() #txt
PA0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start.ivp</name>
    </language>
</elementInfo>
' #txt
PA0 f0 @C|.responsibility Everybody #txt
PA0 f0 81 49 30 30 -21 17 #rect
PA0 f0 @|StartRequestIcon #fIcon
PA0 f5 targetWindow NEW:card: #txt
PA0 f5 targetDisplay TOP #txt
PA0 f5 richDialogId projetTest.RIAboat #txt
PA0 f5 startMethod start() #txt
PA0 f5 type projetTest.Data #txt
PA0 f5 requestActionDecl '<> param;' #txt
PA0 f5 responseActionDecl 'projetTest.Data out;
' #txt
PA0 f5 responseMappingAction 'out=in;
out.boatTransport=result.boatTransportRIA;
' #txt
PA0 f5 windowConfiguration '* ' #txt
PA0 f5 isAsynch false #txt
PA0 f5 isInnerRd false #txt
PA0 f5 userContext '* ' #txt
PA0 f5 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Data output</name>
        <nameStyle>11
</nameStyle>
    </language>
</elementInfo>
' #txt
PA0 f5 200 42 112 44 -31 -8 #rect
PA0 f5 @|RichDialogIcon #fIcon
PA0 f2 expr out #txt
PA0 f2 111 64 200 64 #arcP
PA0 f1 type projetTest.Data #txt
PA0 f1 401 49 30 30 0 15 #rect
PA0 f1 @|EndIcon #fIcon
PA0 f3 expr out #txt
PA0 f3 312 64 401 64 #arcP
PA0 f4 outLink start2.ivp #txt
PA0 f4 type projetTest.Data #txt
PA0 f4 inParamDecl '<> param;' #txt
PA0 f4 actionDecl 'projetTest.Data out;
' #txt
PA0 f4 guid 14C6AD91E136F51F #txt
PA0 f4 requestEnabled true #txt
PA0 f4 triggerEnabled false #txt
PA0 f4 callSignature start2() #txt
PA0 f4 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start2.ivp</name>
    </language>
</elementInfo>
' #txt
PA0 f4 @C|.responsibility Everybody #txt
PA0 f4 81 209 30 30 -24 17 #rect
PA0 f4 @|StartRequestIcon #fIcon
PA0 f6 targetWindow NEW:card: #txt
PA0 f6 targetDisplay TOP #txt
PA0 f6 richDialogId projetTest.RIACombobox #txt
PA0 f6 startMethod start(List<ch.comem.ws.BoatTransport>) #txt
PA0 f6 type projetTest.Data #txt
PA0 f6 requestActionDecl '<List<ch.comem.ws.BoatTransport> listeBoatTransport> param;' #txt
PA0 f6 responseActionDecl 'projetTest.Data out;
' #txt
PA0 f6 responseMappingAction 'out=in;
' #txt
PA0 f6 windowConfiguration '* ' #txt
PA0 f6 isAsynch false #txt
PA0 f6 isInnerRd false #txt
PA0 f6 userContext '* ' #txt
PA0 f6 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Combobox</name>
        <nameStyle>8
</nameStyle>
    </language>
</elementInfo>
' #txt
PA0 f6 168 202 112 44 -30 -8 #rect
PA0 f6 @|RichDialogIcon #fIcon
PA0 f7 expr out #txt
PA0 f7 111 224 168 224 #arcP
PA0 f8 type projetTest.Data #txt
PA0 f8 401 225 30 30 0 15 #rect
PA0 f8 @|EndIcon #fIcon
PA0 f9 expr out #txt
PA0 f9 280 224 401 238 #arcP
>Proto PA0 .type projetTest.Data #txt
>Proto PA0 .processKind NORMAL #txt
>Proto PA0 0 0 32 24 18 0 #rect
>Proto PA0 @|BIcon #fIcon
PA0 f0 mainOut f2 tail #connect
PA0 f2 head f5 mainIn #connect
PA0 f5 mainOut f3 tail #connect
PA0 f3 head f1 mainIn #connect
PA0 f4 mainOut f7 tail #connect
PA0 f7 head f6 mainIn #connect
PA0 f6 mainOut f9 tail #connect
PA0 f9 head f8 mainIn #connect
