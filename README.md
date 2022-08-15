# DockerJsf

#Atividade colabrativa DOCKER e JSF 

#Questões contextuais
1.Qual a diferença entre image e container?
 Imagens: É a complilação doque ira ser feito no container,
 Container: É local aonde corre a execução da imagens.
 
2.Qual a diferença entre os comandos COPY, EXPOSE e ADD?
 COPY copiar um novo arquivo para pasta.
 ADD adicionar um novo arquivo na pasta.
 EXPOSE expor as porta.
 
3.Qual a diferença entre os comandos RUN, CMD e ENTRYPOINT?
 RUN executa comandos dentro da imagen.
 CMD define comanda a serem e executados por ENTYPOINT.
 ENTYPOINT executa comandos ao inicia o container.
 
4.Qual a diferença entre as estratégias de shell e exec?
 EXEC execulta comando para o container selecionado.
 Ja para a utilazão do Shell é possivel execultar comando no terminal duranta o tempo de execução do container.

5.Qual a diferença entre os comandos docker stop <container_id> e docker
kill <container_id>?

 docker stop tenta encera a execução do container.
 ja o docker kill termina instantaneamente.
