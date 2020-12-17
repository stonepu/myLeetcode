

/**
 * ========================udp通道接口=======================
 */

/**
 * 每种类型相当于一个本地端口和一个远端端口的通道，本地端口不可重复
 */
enum UDP_CHANNEL_TYPE{

    VIDEO_CHANNEL,
    AUDIO_CHANNEL,
    VIDEO4_P2P_CHANNEL,
    AUDIO4_P2P_CHANNEL,

    VIDEO_RTCP_CHANNEL,
    AUDIO_RTCP_CHANNEL,
    VIDEO4_P2P_RTCP_CHANNEL,
    AUDIO4_P2P_RTCP_CHANNEL
}

enum MEDIA_TYPE{
    VIDEO,
    AUDIO
}

/**
 *
 * @param localPort 本地端口
 * @param dstIp 目的主机IP
 * @param dstPort 目的主机端口
 */
struct UdpChannelInfo{
    int localPort;
    std::string dstIp;
    int dstPort;
}

/**
 * 开启udp通道
 * @param udpChannelInfo udpChannel的描述信息
 * @param type 通道类型。
 */
void createUdpChannel(const UdpChannelInfo& udpChannelInfo, UDP_CHANNEL_TYPE type);

/**
 * 关闭udp通道
 * @param type 通道类型。
 */
void closeUdpChannel(UDP_CHANNEL_TYPE type);



/**
 * ========================发送数据接口=======================
 */


/**
 * 将编码后的图片进行发送
 * @param pkt 要发送的媒体数据
 * @param type 通道类型。
 */
void sendMsg(AVPacket* pkt, UDP_CHANNEL_TYPE type);


/**
 * 直接发送udp数据，可以发送stun消息，sps与pps消息，sps与pps发送由调用该函数的模块控制
 * @param data 要发送的数据
 * @param len 要发送的数据长度
 * @param type 通道类型。
 */
void sendMsg(uint8_t* data, size_t len, UDP_CHANNEL_TYPE type);



/**
 * ========================接收数据接口=======================
 */
//ICE 属于内部，后期设计
//typedef std::function<void(uint8_t*, size_t)> ICE_CALLBACK;

/**
 * 媒体处理模块对媒体数据处理的回调函数，需要媒体模块实现
 * @param data 媒体处理模块接收的数据
 * @param len 媒体处理模块接收的数据长度
 * @param ts 媒体数据时间戳。
 * @param ssrc 媒体数据ssrc。
 */
typedef std::function<void(uint8_t* data, size_t len, int64_t ts, int64_t ssrc)> MEDIA_CALLBACK;

/**
 * 设置处理视频数据的回调函数
 * @param mediaCallback 视频模块处理数据的回调函数
 */
void setVideoCallback(MEDIA_CALLBACK mediaCallback);

/**
 * 设置处理音频数据的回调函数
 * @param mediaCallback 音频模块处理数据的回调函数，具体要音频模块实现
 */
void setAudioCallback(MEDIA_CALLBACK mediaCallback);



///**
// * ========================ssrc设置接口=======================
// */
//
//
///**
// * addSsrc用来增加ssrc，removeSsrc用来删除ssrc，clearSsrc用来清空所有存储的ssrc
// * @param ssrc 用户的ssrc
// * @param vec 其他用户的ssrc列表
// * @param int64_t 媒体数据时间戳。
// */
//void addSsrc(int64_t ssrc, MEDIA_TYPE type);
//
//void addSsrc(const std::vector<int64_t>& vec, MEDIA_TYPE type);
//
//void removeSsrc(int64_t ssrc, MEDIA_TYPE type);
//
//void clearSsrc();

