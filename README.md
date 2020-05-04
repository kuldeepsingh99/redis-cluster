# How to set up Redis Cluster

## Pull Redis Image

```
$docker pull redis
```

## Create redis configuration file

```
port 6379
cluster-enabled yes
cluster-config-file nodes.conf
cluster-node-timeout 5000
appendonly yes
```

## Create network 

```
$docker create network java_backend
```

## Create Redis Instances

```
$ docker run -d --net java_backend -v /home/ubuntu/redis/redis.conf:/usr/local/etc/redis/redis.conf --name redis-1 redis redis-server /usr/local/etc/redis/redis.conf
$ docker run -d --net java_backend -v /home/ubuntu/redis/redis.conf:/usr/local/etc/redis/redis.conf --name redis-2 redis redis-server /usr/local/etc/redis/redis.conf
$ docker run -d --net java_backend -v /home/ubuntu/redis/redis.conf:/usr/local/etc/redis/redis.conf --name redis-3 redis redis-server /usr/local/etc/redis/redis.conf
$ docker run -d --net java_backend -v /home/ubuntu/redis/redis.conf:/usr/local/etc/redis/redis.conf --name redis-4 redis redis-server /usr/local/etc/redis/redis.conf
$ docker run -d --net java_backend -v /home/ubuntu/redis/redis.conf:/usr/local/etc/redis/redis.conf --name redis-5 redis redis-server /usr/local/etc/redis/redis.conf
$ docker run -d --net java_backend -v /home/ubuntu/redis/redis.conf:/usr/local/etc/redis/redis.conf --name redis-6 redis redis-server /usr/local/etc/redis/redis.conf

```

Executing these command will create 6 Redis instances, for demo purpose i am create container in one machine, on production environment we should container in different instances.

## Create Cluster

```
$ docker exec redis-1 redis-cli --cluster create 172.29.0.2:6379 172.29.0.3:6379 172.29.0.4:6379 172.29.0.5:6379 172.29.0.6:6379 172.29.0.7:6379 --cluster-replicas 1

```

This command will create cluster with 3 master node and 3 slaves


# Set up Spring boot MYSQL Instance

## Exceute the docker compose yaml file to create spring boot and mysql instance
