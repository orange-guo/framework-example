allprojects {
	repositories {
		maven {
			setUrl("http://mirrors.tencent.com/nexus/repository/maven-public/")
		}
		maven {
			setUrl("https://mirrors.huaweicloud.com/repository/maven/")
		}
		maven {
			setUrl("http://maven.aliyun.com/nexus/content/groups/public/")
		}
		maven {
			setUrl("https://oss.sonatype.org/content/repositories/snapshots")
		}
		maven {
			setUrl("https://kotlin.bintray.com/kotlinx")
		}
	}
}