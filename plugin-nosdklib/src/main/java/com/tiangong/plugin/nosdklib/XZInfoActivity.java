package com.tiangong.plugin.nosdklib;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class XZInfoActivity extends AppCompatActivity {
   private Item item;
   private String [] urls={
            "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2085494876,3787393413&fm=173&app=25&f=JPEG?w=640&h=417&s=F50859322CB0F29CCC9D0CC20300E0A2",
            "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1078568353,1777353953&fm=173&app=25&f=JPEG?w=640&h=391&s=A0107A95DE4126C8DC0C74CE03003073",
            "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2976965200,2583954165&fm=173&app=25&f=JPEG?w=640&h=371&s=3D24CF15D6725D9E833D1DC103003090",
            "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=3349193160,1918520981&fm=173&app=25&f=JPEG?w=640&h=360&s=3D64C3140680714FC6100D47030030B2",
            "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=3849512499,1105524903&fm=173&app=25&f=JPEG?w=640&h=475&s=5A21796CDC4B2655534C859A0100C09B",
            "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=894236773,2622262169&fm=173&app=25&f=JPEG?w=640&h=410&s=F9071B74173A40290CDD24DE010050B2",
            "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3092070103,2033016267&fm=173&app=25&f=JPEG?w=640&h=422&s=9D8A3F7F0201535151A374770300D068",
            "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1755669633,1970108246&fm=173&app=25&f=JPEG?w=640&h=378&s=92E4B70FEA5F164752639BA10300E005",
            "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=545389939,2031723271&fm=173&app=25&f=JPEG?w=640&h=473&s=5EB6A644CE334594038038A30300E080",
            "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1525797807,3683995255&fm=173&app=25&f=JPEG?w=640&h=447&s=25501CC6466A35154B9795220300501A",
            "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2188002681,1065586907&fm=173&app=25&f=JPEG?w=584&h=395&s=683831D5423303801898ECFF0300C003",
            "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=660168367,2302605655&fm=173&app=25&f=JPEG?w=538&h=317&s=F9271F7475E053119E442CC60300F0F1"};

    private String[] desc = {
            "热情有活力、勇于接受挑战、做事积极、坦白、乐观进取有自信、有明快的决断力、率真、深爱自由、勇于接受新观念、讲义气、精力旺盛。白羊座从来不是一个缺乏行动力的星座，这一星座的人对自己的能力很有自信，渴望进步。在职场中，他们勇往直前，工作积极热情，这样的性格使他们很容易得到领导的赏识。他们是积极有干劲的职场行动先锋，喜爱出风头，所以要开拓业务，白羊座的人绝对是首选。",
            "处女座往往谦虚、喜欢整洁、处事小心、头脑清晰而分析能力强、能明辨是非，有细腻和怀旧情怀，但是他们会很理性地表达自己的感想，又实际又贴心。如果他们觉得你好，会由衷地赞你，如果不觉得怎样，也不会附和你，算是清醒着浪漫的一类。",
            "名副其实的现实主义者，具有持之以恒的精神，适合从事需要顽强毅力和付出长期艰苦努力的工作。你永远不知道一个金牛在毫无预兆的情况下和一个人突然疏远，在这之前那个人的一举一动在金牛的精神世界里展开了多少次世界大战。金牛忍耐力极好，他们愿意一次又一次给不喜欢的人机会来缓和关系。直到忍无可忍的那天，金牛对这段关系完全失去信心，然后消失在彼此的世界里老死不相往来。",
            "巨蟹座生性善良又敏感多疑。ta们对感情抱有信仰，相信纯真、相信天长地久，所以有时是挑剔的。ta们重视家庭，忠于爱情和友情，天生具有强烈母性本能，这种本能在经过岁月沉淀之后，会变得更加明显，举手投足之间，充满无法用言语表达的动人魅力。",
            "魔羯座的人独立而充满斗志，总是给人一副勤勉沉稳的样子，这是为了按部就班实现自己的目标做出来的举动。凡事有计划性，很有耐心。然而含蓄不善于表达，缺乏安全感。不过他们稳健踏实，会小心翼翼渡过艰难的处境。通常都很健壮，有过人的耐力、意志坚决、有时间观念、有责任感、重视权威和名声，对领导统御很有一套，自成一体，另外组织能力也不错。",
            "双鱼座的人对于他人的情绪感知很敏感。他们温柔善良，善解人意、坦诚而迷人、不会随意伤人、内心柔软、富有同情心喜欢帮助别人。双鱼座多情浪漫爱幻想，爱做梦。但是由于有时候会沉溺于自己的梦而导致脱离现实。他们同时也很敏感脆弱，他们很容易受到伤害。一旦受到伤害或者是受挫，他们就会对自己失去自信心然后逃避现实。",
            "射手座是代表自由的星座。自由、乐观、热情、直爽是他们的标签。他们特立独行，爱好自由，不愿意被规范、教条束缚，无论是外在的物质还是精神层面，他们都希望追寻自己的想法及内心。若长久处在一个相同的环境会让他们变得沮丧甚至暴躁。射手座随时带着乐观自信的人生态度，追求自己内心的精神世界。他们善于发现自己未知的领域，也愿意为之学习。",
            "狮子座有着宏伟的理想，总想靠自己的努力成为人上人，向往高高在上的优越感，也期待被仰慕被崇拜的感觉，有点儿自信有点儿自大。狮子男的大男人气息很重，爱面子，狮子女热情阳光，对朋友讲义气。喜欢成为焦点人物的狮子座，也有脆弱之时，因为他们太在乎别人对他的看法，往往因此而不快乐；不肯认输的个性，也是令自己不愉快的泉源。",
            "双子座的人喜爱变化。盎然的春意表现在双子座的人性格上的主要特征是思维善变，无拘无束，对外界包罗万象的事物的永无休止的好奇心，可以说是机敏、好动又不安的星座",
            "水瓶座的人有很强的自我个性，他们最大的特点是革新，他们追求独一无二的生活方式，崇尚自由。他们对人友善又注重隐私，喜欢结交每一类朋友，但是确很难与他们交心，要真正与他们交心需要很长的时间。他们对自己的家人会显得冷淡和疏远，不善表达自己对家人的感情。",
            "在困境中，天秤座人如果无法一展所长，久而久之，就变得胆小、怯懦，逃避现实，只有找寻属于自己的天空，在合适的环境中工作，才能让天秤座人得到正常的身心成长。凡事要求公平，也极力反对不公平的事，是天秤座性格最明显的地方。他对于不合理的事，采取激烈的态度，不是愤怒，便是冷漠以对。",
            "天蝎座的人倔强而深沉，在情感上属多愁善感的敏锐型，常以自我为中心，但通常天蝎是深情且多情的，虽然表面上看起来很平静、沉默寡言，但内心却是波涛汹涌。对于感情上的背叛绝对不能忍受，属于敢爱敢恨的类型。思虑周密，体贴是天蝎座最大的优点，可是却很少表现出来。天蝎座对别人的秘密一定是守口如瓶，防卫心重，几乎不会放全部的信任在任何人身上。有着强烈的第六感、神秘的感知能力及敏锐的观察力，但往往仍靠感觉来做决定。由于自制力强，又带有神秘色彩，所以常给人感到难以接近、冷若冰霜的错觉。",};
    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xzinfo);
        item = (Item) getIntent().getSerializableExtra("item");
        initToolar();
        imageView = findViewById(R.id.iv);
        textView  = findViewById(R.id.tv_desc);
        Glide.with(this).load(urls[item.getId()]).into(imageView);
        textView.setText(desc[item.getId()]);
    }

    private void initToolar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        if(null!=toolbar){
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("");
                toolbar.setNavigationIcon(R.mipmap.fanhuijian);
                getSupportActionBar().setDisplayShowHomeEnabled(true);

            TextView textView = findViewById(R.id.title_name);
            if(item!=null)
            textView.setText(item.getName());
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                finishAfterTransition();
            } else {
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
