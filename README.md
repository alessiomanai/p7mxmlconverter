# PosteMobile Casa Web - Convertitore fattura da p7m a pdf
### Semplice software per convertire il file .p7m ed estrarre il pdf allegato.

Scritto in Java 11.

## Build

`./gradlew clean build -x test`

## Run

Eseguire sul terminale:

`java -jar p7mxmlconverter.jar /path/file.xml.p7m /temp/file.xml /destinazione/file.pdf`

Il primo file è il file .p7m in allegato alla mail, il secondo sarà un file xml di appoggio, il nostro p7m convertito.
Il terzo file sarà la destinazione del pdf allegato al p7m, la nostra fattura.

## Licence

	P7mxmlconverter

	Copyright (C) 2023  Alessio Manai

 	This program is free software: you can redistribute it and/or modify
 	it under the terms of the GNU General Public License as published by
 	the Free Software Foundation, either version 3 of the License, or
 	(at your option) any later version.
	
 	This program is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 	GNU General Public License for more details.
	
	You should have received a copy of the GNU General Public License
	along with this program.  If not, see <http://www.gnu.org/licenses/>.

 			alessiomanai.cf      alessio.manai@outlook.com
