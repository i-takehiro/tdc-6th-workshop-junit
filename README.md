東北デベロッパーズカンファレンス2014「6周年記念ワークショップ祭り！」JUnitハンズオン
========================================================================

##事前準備
JUnitハンズオンでは **ノートPCを使用します** のでご持参ください。  
ノートPCには以下のソフトウェアをインストールしておいて下さい。  
(**Wi-Fiをお持ちの方は出来る限りご持参ください**)

### Java

**Java 7** を使用します。(**Java 6** でも構いません)
<http://www.oracle.com/technetwork/java/javase/downloads/index.html>

### Eclipse

IDEとして **Eclipse** を使用します。  
<http://www.eclipse.org/downloads/>  
-> どれをインストールしてよいか分からない場合は **Eclipse IDE for Java Developers** を選んで下さい。

必須ではありませんが、以下のEclipseプラグインを入れておくことをお勧めします。

- **Quick JUnit Plugin for Eclipse**  
<http://quick-junit.sourceforge.jp/>
- **EclEmma**  
<http://www.eclemma.org/>

Eclipse以外のIDEでも構いませんが、十分にサポート出来ない可能性がありますので御了承ください。

### JUnit

**JUnit 4.11** を使用します。  
<http://junit.org/>  
-> ワークショップ内でセットアップしますので事前準備は不要です。

### Gradle (任意)

ビルドツールとして **Gradle** を使用します。

#### Windowsの場合

以下を参考にして下さい。  
<http://gradle.monochromeroad.com/docs/userguide/installation.html>

#### Mac/Linuxの場合

**gvm** を使用してインストールして下さい。

    $ gvm install gradle

**gvm** 自体のインストールは以下を参考にして下さい。  
<http://gvmtool.net/>

## 環境構築

リポジトリの内容を空のEclipseプロジェクトに取り込んで下さい  
コマンドプロンプト／ターミナル上でEclipseプロジェクトのルートに移動して以下のコマンドを実行して環境構築を行います  

Gradleをインストールしてる場合
 
    $ gradle eclipse
    

Gradleをインストールしていない場合(Windows)

    $ gradlew.bat eclipse

Gradleをインストールしていない場合(Mac/Linux)

    $ gradlew eclipse


## ワークショップの流れ

- 質問
- 環境セットアップ
    - Gradleとは
- JUnit基礎
    - 初めてのユニットテスト
    - 学習テストとは
        - 演習
    - アノテーション
    - Matcher
        - 演習
    - テストの構造化
    - パラメータ化テスト
        - 演習
- TDD(テスト駆動開発)
    - テスト駆動開発とは
    - デモ
    - 演習

## 参考URL

Java7 APIリファレンス  
<http://docs.oracle.com/javase/jp/7/api/>

Gradle 日本語ドキュメント  
<http://gradle.monochromeroad.com/docs/>


## 参考書籍

**JUnit実践入門 ~体系的に学ぶユニットテストの技法 (WEB+DB PRESS plus)**  
<http://www.amazon.co.jp/dp/477415377X>

***

[![Build Status](https://travis-ci.org/i-takehiro/tdc-6th-workshop-junit.png?branch=master)](https://travis-ci.org/i-takehiro/tdc-6th-workshop-junit)
