import net.fabricmc.loom.task.RemapJarTask
import net.fabricmc.loom.task.RemapSourcesJarTask

plugins {
	wrapper
	idea
	id("fabric-loom") version Fabric.Loom.version
	id("maven-publish")
    id("net.minecrell.licenser") version "0.4.1"
}

java {
	sourceCompatibility = JavaVersion.VERSION_1_8
	targetCompatibility = JavaVersion.VERSION_1_8
}

idea {
	module {
		excludeDirs.add(file("run"))
	}
}

base {
	archivesBaseName = Constants.name
}

version = "${Constants.version}+${Constants.minecraftVersionVer}"
group = "team.abnormals"

repositories {
	mavenCentral()
	mavenLocal()
	maven("https://maven.fabricmc.net")
	maven("https://minecraft.curseforge.com/api/maven")
    maven("http://maven.sargunv.s3-website-us-west-2.amazonaws.com/")
	maven("http://server.bbkr.space:8081/artifactory/libs-snapshot/")
	maven("http://server.bbkr.space:8081/artifactory/libs-release/")
	maven("https://maven.jamieswhiteshirt.com/libs-release/")
	maven("https://maven.abusedmaster.xyz")
	maven("https://jitpack.io")
	maven("https://maven.sk89q.com/repo")
	maven("https://maven.jamieswhiteshirt.com/libs-release/")
}

dependencies {
	minecraft(group = "com.mojang", name = "minecraft", version = Minecraft.version)
	mappings(group = "net.fabricmc", name = "yarn", version = "${Minecraft.version}+${Fabric.Yarn.version}")
	modCompile(group = "net.fabricmc", name = "fabric-loader", version = Fabric.Loader.version)

	modApi(group = "net.fabricmc.fabric-api", name = "fabric-api", version = Fabric.API.version)

    modImplementation(group = "me.sargunvohra.mcmods", name = "auto-config", version = Dependencies.AutoConfig.version)
	modImplementation("com.github.Siphalor:tweed-api:2.2.0-beta.3")

	modCompile("team.abnormals:AbnormaLib:0.8.0+1.14.4")

	// For dev env testing
	modImplementation(group = "com.jamieswhiteshirt", name = "developer-mode", version = "1.0.13")
	modImplementation(group = "me.shedaniel", name = "RoughlyEnoughItems", version = Dependencies.REI.version)
	modImplementation(group = "io.github.prospector.modmenu", name = "ModMenu", version = Dependencies.ModMenu.version)
	modImplementation("leaf-decay:leaf:decay:1.0.3")
	modImplementation("com.github.swordglowsblue:artifice:0.3.3")
	modImplementation("worldedit:worldedit-fabric-mc1.14.4:7.0.1:rc1")
	modCompile("com.github.TerraformersMC:Terrestria:1.14-SNAPSHOT")
	modCompile("com.github.TerraformersMC:Terraform:669113a631")

	compile(group="com.google.code.findbugs", name="jsr305", version="3.0.2")
}

tasks.getByName<ProcessResources>("processResources") {
	filesMatching("fabric.mod.json") {
		expand(
				mutableMapOf(
						"version" to version
				)
		)
	}
}

val javaCompile = tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

val jar = tasks.getByName<Jar>("jar") {
    from("LICENSE")
}

val remapJar = tasks.getByName<RemapJarTask>("remapJar")

val remapSourcesJar = tasks.getByName<RemapSourcesJarTask>("remapSourcesJar")

publishing {
	publications {
		create<MavenPublication>("mavenJava") {
			artifactId = Constants.name
			artifact(jar) {
				builtBy(remapJar)
			}
			pom {
				name.set(Constants.name)
				description.set(Constants.description)
				url.set(Constants.url)
				licenses {
					license {
						name.set("MIT License")
						url.set("https://tldrlegal.com/license/mit-license#fulltext")
					}
				}
				developers {
					developer {
						id.set("team_abnormals")
						name.set("Team Abnormals")
					}
				}
			}
		}
	}
}