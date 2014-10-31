package ru.argus.training.messages;
/**
	Реализует очень простой механизм переключения сообщения в сессии.
	
	При этом здесь интересный момент, который показывает - абсолютно все бины являются CDI Managed Bean (за некоторым исключением).
	
	Классы-реализации {@link ru.argus.training.messages.Messages} помечены аннотации {@link javax.enterprise.inject.Vetoed}, которая запрещает
	CDI создавать для них managed beans. Если эту аннотации убрать, то в точке инжекцией будет ошибка:
	<code>
		Multiple beans are eligible for injection to the injection point [JSR-299 §5.2.1]:
	</code>
	C возможными кандидатами:
	<ul>	
		<li> {@link ru.argus.training.messages.Messages}
		<li> {@link ru.argus.training.messages.EnglishMessages}
		<li> {@link ru.argus.training.messages.RussianMessages}
	</ul>
	
	Мы же хотим, чтобы за выбор отвечал механизм {@link ru.argus.training.LanguageService}
 */
