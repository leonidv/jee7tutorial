package ru.argus.training.messages;
/**
	��������� ����� ������� �������� ������������ ��������� � ������.
	
	��� ���� ����� ���������� ������, ������� ���������� - ��������� ��� ���� �������� CDI Managed Bean (�� ��������� �����������).
	
	������-���������� {@link ru.argus.training.messages.Messages} �������� ��������� {@link javax.enterprise.inject.Vetoed}, ������� ���������
	CDI ��������� ��� ��� managed beans. ���� ��� ��������� ������, �� � ����� ��������� ����� ������:
	<code>
		Multiple beans are eligible for injection to the injection point [JSR-299 �5.2.1]:
	</code>
	C ���������� �����������:
	<ul>	
		<li> {@link ru.argus.training.messages.Messages}
		<li> {@link ru.argus.training.messages.EnglishMessages}
		<li> {@link ru.argus.training.messages.RussianMessages}
	</ul>
	
	�� �� �����, ����� �� ����� ������� �������� {@link ru.argus.training.LanguageService}
 */
