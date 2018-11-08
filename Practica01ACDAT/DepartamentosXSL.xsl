<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:template match="/">
		<html>
			<head>
				<title>
					ACDAT
				</title>
			</head>
			<body>
				<h2>Departamentos</h2>
				<ul style="list-style:none;">
					<hr/>
					<xsl:for-each select="Departamentos/Departamento">
					<xsl:sort data-type="text" order="ascending"/>
						<li><strong>ID: </strong><xsl:value-of select="ID"/></li>
						<li><strong>Tipo: </strong><xsl:value-of select="Tipo"/></li>
						<li><strong>Nombre: </strong><xsl:value-of select="Nombre"/></li>
						<li><strong>Domicilio: </strong><xsl:value-of select="Domicilio"/></li>
						<li><strong>Ciudad: </strong><xsl:value-of select="Ciudad"/></li>
						<li><strong>CP: </strong><xsl:value-of select="CP"/></li>
						<li><strong>Provincia: </strong><xsl:value-of select="Provincia"/></li>
						<li><strong>Pais: </strong><xsl:value-of select="Pais"/></li>
						<hr/>
					</xsl:for-each>
				</ul>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>