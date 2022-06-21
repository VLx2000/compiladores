# compiladores-t1

## Ubuntu
### Dependências
> Java 11
```
sudo apt install openjdk-11-jdk maven gcc
```

### Para executar
#### Compile o programa
```
mvn clean package
```

#### E rode o script com 
```
chmod +x ./script.sh && ./script.sh
```

#### Ou execute o seguinte comando na pasta do projeto
```
chmod +x ./target/t1-1.0-SNAPSHOT-jar-with-dependencies.jar &&
java -jar ./corretor-automatico/corretor-automatico.jar \
"java -jar $PWD/target/t1-1.0-SNAPSHOT-jar-with-dependencies.jar" \
gcc \
./tmp \
./casos-de-teste \
"769699,769681,769734" \
t1
```

## Windows

> Obs: Os casos de teste e o corretor automático já estão inclusos no projeto