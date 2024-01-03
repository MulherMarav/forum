package br.com.mulhermarav.forum.config

import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair.fromSerializer
import java.time.Duration

@Configuration
@EnableCaching
class RedisCacheConfig {

    @Bean
    fun cacheManager(redisConnectionFactory: RedisConnectionFactory?): CacheManager {

        var cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
            .serializeValuesWith(fromSerializer(GenericJackson2JsonRedisSerializer()))

        cacheConfiguration = cacheConfiguration.entryTtl(Duration.ofMinutes(2)) // tempo de expiração de 2 minutos

        return RedisCacheManager.builder(redisConnectionFactory!!)
            .cacheDefaults(cacheConfiguration)
            .build()
    }
}

